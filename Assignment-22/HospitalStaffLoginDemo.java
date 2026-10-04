import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalStaffLoginDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Staff Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String query = "SELECT role FROM staff WHERE login_id = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, loginId);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                System.out.println("Authentication Successful!");
                System.out.println("Access Granted: " + role + " Dashboard unlocked.");
            } else {
                System.out.println("Authentication Failed: Invalid Staff ID or Password.");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}