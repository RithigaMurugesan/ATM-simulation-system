import java.util.Scanner;

public class ATMSimulator {
    // Initial balance
    static double balance = 10000.00;
    static final int PIN = 1234; // Hardcoded PIN for simplicity
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Simulation System");

        if (authenticateUser()) {
            showMenu();
        } else {
            System.out.println("Too many failed attempts. Card blocked.");
        }
    }

    static boolean authenticateUser() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();
            if (enteredPin == PIN) {
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Try again.");
            }
        }
        return false;
    }

    static void showMenu() {
        while (true) {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void viewBalance() {
        System.out.printf("Your current balance is: ₹%.2f\n", balance);
    }

    static void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.\n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
