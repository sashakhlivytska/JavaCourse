import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit_ValidAmount_ShouldIncreaseBalance() throws NegativeAmountException {
        BankAccount account = new BankAccount(1, "Test", 100);

        account.deposit(50);

        assertEquals(new BigDecimal("150"), account.getBalance());
    }

    @Test
    void deposit_NegativeAmount_ShouldThrowNegativeAmountException() {
        BankAccount account = new BankAccount(1, "Test");

        assertThrows(NegativeAmountException.class, () -> account.deposit(-50));
    }

    @Test
    void withdraw_ValidAmount_ShouldDecreaseBalance() throws NegativeAmountException, InsufficientFundsException {
        BankAccount account = new BankAccount(1, "Test", 100);

        account.withdraw(50);

        assertEquals(new BigDecimal("50"), account.getBalance());
    }

    @Test
    void withdraw_NegativeAmount_ShouldThrowNegativeAmountException() {
        BankAccount account = new BankAccount(1, "Test");

        assertThrows(NegativeAmountException.class, () -> account.withdraw(-50));
    }

    @Test
    void withdraw_InsufficientFunds_ShouldThrowInsufficientFundsException() {
        BankAccount account = new BankAccount(1, "Test", 50);

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }

    @Test
    void getBalance_ShouldReturnCorrectBalance() {
        BankAccount account = new BankAccount(1, "Test", 75);

        assertEquals(75, account.getBalance());
    }

    @Test
    void getAccountNumber_ShouldReturnCorrectAccountNumber() {
        BankAccount account = new BankAccount(123, "Test");

        assertEquals(123, account.getAccountNumber());
    }

    @Test
    void getAccountSummary_ShouldReturnCorrectSummary() {
        BankAccount account = new BankAccount(1, "Test", 100);

        String expectedSummary = "Bank account Test (1), balance: 100.0";

        assertEquals(expectedSummary, account.getAccountSummary());
    }
}
