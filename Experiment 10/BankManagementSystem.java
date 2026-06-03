// Abstract Class
abstract class BankAccount {
    // Encapsulation: Private data members
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: Rs." + amount);
    }

    // Display Details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: Rs." + balance);
    }

    // Abstract Method
    abstract double calculateInterest();
}

// Savings Account Class
class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }
}

// Current Account Class
class CurrentAccount extends BankAccount {

    public CurrentAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }
}

// Main Class
public class BankManagementSystem {
    public static void main(String[] args) {

        // Creating Objects
        SavingsAccount sa = new SavingsAccount(101, "Kashish", 10000);
        CurrentAccount ca = new CurrentAccount(201, "Tannu", 15000);

        // Deposit Money
        sa.deposit(2000);
        ca.deposit(3000);

        // Display Details
        System.out.println("\nSavings Account Details");
        sa.displayDetails();
        System.out.println("Interest: Rs." + sa.calculateInterest());

        System.out.println("\nCurrent Account Details");
        ca.displayDetails();
        System.out.println("Interest: Rs." + ca.calculateInterest());
    }
}