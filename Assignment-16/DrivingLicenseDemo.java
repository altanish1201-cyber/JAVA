import java.util.Scanner;

class UnderAgeException extends Exception {
    UnderAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseDemo {

    static void checkEligibility(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("User is below 18 years of age.");
        }
        System.out.println("User is eligible for a driving license.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);

        } catch (UnderAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());

        } finally {
            System.out.println("Verification process completed.");
        }

        sc.close();
    }
}