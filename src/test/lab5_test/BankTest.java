import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.bank.Bank;
import lab5.bankAccount.BankAccount;
import lab5.exceptions.AccountNotFoundException;
import lab5.exceptions.InsufficientFundsException;
import lab5.exceptions.NegativeAmountException;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() throws NegativeAmountException {
        BankAccount account = bank.createAccount("Alis", 2000);
        assertNotNull(account);
        assertEquals(2000, account.getBalance());
    }

    @Test
    public void testNegativeAmountExceptionOnCreateAccount() {
        assertThrows(NegativeAmountException.class, () -> bank.createAccount("Alis", -2000));
    }

    @Test
    public void testFindAccount() throws NegativeAmountException, AccountNotFoundException {
        BankAccount createdAccount = bank.createAccount("Alis", 2000);
        int accountNumber = createdAccount.getAccountNumber();
        BankAccount foundAccount = bank.findAccount(accountNumber);
        assertEquals(createdAccount, foundAccount);
    }

    @Test
    public void testAccountNotFoundException() {
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount(-5));
    }

    @Test
    public void testTransferMoney() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException {
        BankAccount account1 = bank.createAccount("Alis", 2000);
        BankAccount account2 = bank.createAccount("Edward", 1500);

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 1500);

        assertEquals(1500, account1.getBalance());
        assertEquals(2000, account2.getBalance());
    }

    @Test
    public void testInsufficientFundsExceptionOnTransferMoney() throws NegativeAmountException {
        BankAccount account1 = bank.createAccount("Alis", 2000);
        BankAccount account2 = bank.createAccount("Edward", 1500);

        assertThrows(InsufficientFundsException.class, () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 5000));
    }

    @Test
    public void testNegativeAmountExceptionOnTransferMoney() throws NegativeAmountException {
        BankAccount account1 = bank.createAccount("Alis", 2000);
        BankAccount account2 = bank.createAccount("DEdward", 1500);

        assertThrows(NegativeAmountException.class, () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), -500));
    }
}
