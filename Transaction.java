
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int accountNumber;
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(int accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return type + " | Amount: " + amount
                + " | Date: " + dateTime.format(formatter);
    }
}
