package ATM;
//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        atm.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        atm.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you for using Abhijeet's ATM!");
                    scanner.close(); // Close the Scanner before exiting the program
                    return;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//