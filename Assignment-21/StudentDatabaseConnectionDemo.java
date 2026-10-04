import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDatabaseConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            if (con != null && !con.isClosed()) {
                System.out.println("Connection Status: Connected");
                System.out.println("Student database is connected successfully!");
            } else {
                System.out.println("Connection Status: Failed");
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error connecting to Student database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}