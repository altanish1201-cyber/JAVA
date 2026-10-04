import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDisplayDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        String query = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            int count = 1;
            while (rs.next()) {
                System.out.println("--- Record #" + count + " ---");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: $" + rs.getDouble("salary"));
                System.out.println();
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}