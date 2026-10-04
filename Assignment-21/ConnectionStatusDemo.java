import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionStatusDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            if (con != null && !con.isClosed()) {
                System.out.println("Database connection established successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}