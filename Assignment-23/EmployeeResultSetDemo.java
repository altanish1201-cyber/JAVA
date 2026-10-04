import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeResultSetDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        String query = "SELECT id, name, department, salary FROM employee";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Fetching employee records sequentially...\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID : " + id);
                System.out.println("Name        : " + name);
                System.out.println("Department  : " + dept);
                System.out.println("Salary      : $" + salary);
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}