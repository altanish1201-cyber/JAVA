import java.util.Scanner;

public class LoginDemo {

    static void checkPassword(String password) throws Exception {
        if (!password.equals("admin123")) {
            throw new Exception("Invalid password entered.");
        }
        System.out.println("Login successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            checkPassword(password);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {
            System.out.println("Login verification completed.");
        }

        sc.close();
    }
}