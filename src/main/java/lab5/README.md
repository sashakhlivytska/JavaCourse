# Лабораторна робота №5

**Виконала: Хлівицька Олександра Віталіївна**

**Група: ПД-32**

## Опис роботи

1. Виконано реалізацію класу [BankAccount.java](BankAccount.java), який має поля `accountNumber`, `accountName` і `balance`, а також методи для доступу до цих полів. Додано функції для маніпуляції балансом, такі як `deposit(double amount)`, `withdraw(double amount)`
2. Створено клас [Bank.java](Bank.java) , який відповідає за створення банківських акаунтів та виконання різноманітних операцій. Додані відповідні виняткові ситуації, що повідомляють про невдалі операції:
   - [AccountNotFoundException.java](exceptions/AccountNotFoundException.java) - означає що вказаний акаунт не існує.
   - [InsufficientFundsException.java](exceptions/InsufficientFundsException.java) - означає ща на балансі недостатньо коштів для проведення операції.
   - [NegativeAmountException.java](exceptions/NegativeAmountException.java) - означає що операція не підтримує від'ємні значення.
