
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        int choice = 0;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                    } else {
                        bankService.createAccount(name);
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccount = readInt(scanner);

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = readDouble(scanner);

                    bankService.deposit(depositAccount, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccount = readInt(scanner);

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = readDouble(scanner);

                    bankService.withdraw(withdrawAccount, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int balanceAccount = readInt(scanner);

                    bankService.checkBalance(balanceAccount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int historyAccount = readInt(scanner);

                    bankService.showTransactionHistory(historyAccount);
                    break;

                case 6:
                    System.out.println("Thank you for using our application!");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1 to 6.");
            }

        } while (choice != 6);

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid amount: ");
            }
        }
    }
}
