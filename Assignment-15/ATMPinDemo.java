import java.util.Scanner;

public class ATMPinDemo {

    static void checkPin(int pin) throws Exception {
        if (pin != 1234) {
            throw new Exception("Invalid ATM PIN.");
        }
        System.out.println("PIN verified successfully. Access granted.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            checkPin(pin);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {
            System.out.println("Verification process has completed.");
        }

        sc.close();
    }
}