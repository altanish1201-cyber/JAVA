import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeCRUDDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            
            // 1. CREATE
            String insertSql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsert = con.prepareStatement(insertSql);
            pstmtInsert.setString(1, "Anish");
            pstmtInsert.setString(2, "IT");
            pstmtInsert.setDouble(3, 75000.0);
            pstmtInsert.executeUpdate();
            System.out.println("Employee record created.");

            // 2. READ
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            System.out.println("--- Employee Records ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") 
                        + " | Dept: " + rs.getString("department") + " | Salary: $" + rs.getDouble("salary"));
            }

            // 3. UPDATE
            String updateSql = "UPDATE employee SET salary = ? WHERE name = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(updateSql);
            pstmtUpdate.setDouble(1, 82000.0);
            pstmtUpdate.setString(2, "Anish");
            pstmtUpdate.executeUpdate();
            System.out.println("Employee record updated.");

            // 4. DELETE
            String deleteSql = "DELETE FROM employee WHERE name = ?";
            PreparedStatement pstmtDelete = con.prepareStatement(deleteSql);
            pstmtDelete.setString(1, "Anish");
            pstmtDelete.executeUpdate();
            System.out.println("Employee record deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}