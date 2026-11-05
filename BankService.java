
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<BankAccount> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    private int nextAccountNumber = 1001;

    // Create a new account
    public void createAccount(String holderName) {
        BankAccount account =
                new BankAccount(nextAccountNumber, holderName);

        accounts.add(account);

        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + nextAccountNumber);

        nextAccountNumber++;
    }

    // Find an account by account number
    private BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            account.deposit(amount);

            transactions.add(new Transaction(
                    accountNumber, "DEPOSIT", amount));

            System.out.println("Deposit successful!");
            System.out.printf("Balance: %.2f%n",
                    account.getBalance());
        }
    }

    // Withdraw money
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            account.withdraw(amount);

            transactions.add(new Transaction(
                    accountNumber, "WITHDRAWAL", amount));

            System.out.println("Withdrawal successful!");
            System.out.printf("Balance: %.2f%n",
                    account.getBalance());
        }
    }

    // Check account balance
    public void checkBalance(int accountNumber) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Account Holder: "
                    + account.getHolderName());
            System.out.printf("Current Balance: %.2f%n",
                    account.getBalance());
        }
    }

    // Display transaction history for one account
    public void showTransactionHistory(int accountNumber) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        boolean found = false;

        System.out.println("Transaction History:");

        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber() == accountNumber) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found.");
        }
    }
}
