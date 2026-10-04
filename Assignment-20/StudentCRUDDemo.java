import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentCRUDDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            // 1. CREATE (Insert Student)
            String insertSql = "INSERT INTO student (roll_no, name, course, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmtInsert = con.prepareStatement(insertSql);
            pstmtInsert.setInt(1, 101);
            pstmtInsert.setString(2, "Anish");
            pstmtInsert.setString(3, "CSE");
            pstmtInsert.setDouble(4, 88.5);
            pstmtInsert.executeUpdate();
            System.out.println("Student inserted successfully.");

            // 2. READ (Select All Students)
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            System.out.println("--- Student Details ---");
            while (rs.next()) {
                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");
                System.out.println("Roll No: " + rollNo + " | Name: " + name 
                        + " | Course: " + course + " | Marks: " + marks);
            }

            // 3. UPDATE (Update Marks)
            String updateSql = "UPDATE student SET marks = ? WHERE roll_no = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(updateSql);
            pstmtUpdate.setDouble(1, 92.0);
            pstmtUpdate.setInt(2, 101);
            pstmtUpdate.executeUpdate();
            System.out.println("Student marks updated.");

            // 4. DELETE (Remove Student)
            String deleteSql = "DELETE FROM student WHERE roll_no = ?";
            PreparedStatement pstmtDelete = con.prepareStatement(deleteSql);
            pstmtDelete.setInt(1, 101);
            pstmtDelete.executeUpdate();
            System.out.println("Student deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}