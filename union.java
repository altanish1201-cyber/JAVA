import java.util.Scanner;

public class union {
    static float balance = 0;

    static float deposit(float deposit1) {
        balance = (balance + deposit1);
        System.out.println("\nYour Balance Amount: " + balance);
        return balance;
    }

    static float withdraw(float withdraw1) {
        balance = (balance - withdraw1);
        System.out.println("\nYour Balance Amount: " + balance);
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        System.out.println("\nWelcome to Union Bank of India: Bank App");
        System.out.print("Customer ID:");
        int cust = sc.nextInt();
        while (ch != 4) {
            System.out.print("\nSelect an Option:\n\n1.balance \n2.deposit\n3.withdraw\n4.exit\nEnter Your Choice: ");
            ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("\nYour Balance Amount: " + balance);
            } else if (ch == 2) {
                System.out.print("Enter Amount to be deposited: ");
                float deposit1 = sc.nextFloat();
                deposit(deposit1);
            } else if (ch == 3) {
                System.out.print("Enter Amount to be withdrawn: ");
                float withdraw1 = sc.nextFloat();
                withdraw(withdraw1);
            } else if (ch == 4) {
                System.out.println("closing account...");
            } else {
                System.out.println("Please enter a valid choice");
            }

        }
    }
}
