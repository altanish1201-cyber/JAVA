<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%!
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "password";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; }
        td, th { border: 1px solid #555; padding: 6px 12px; }
        .form td { border: none; }
        input { padding: 4px; }
        .msg { color: green; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Employee Management System</h2>
    <form method="post" action="EmployeeCRUD.jsp">
        <table class="form">
            <tr><td>Employee ID</td><td><input type="number" name="empId" required></td></tr>
            <tr><td>Name</td><td><input type="text" name="name"></td></tr>
            <tr><td>Department</td><td><input type="text" name="department"></td></tr>
            <tr><td>Salary</td><td><input type="number" step="0.01" name="salary"></td></tr>
            <tr><td colspan="2">
                <input type="submit" name="action" value="Add">
                <input type="submit" name="action" value="Update">
                <input type="submit" name="action" value="Delete">
            </td></tr>
        </table>
    </form>
<%
    String action = request.getParameter("action");
    String message = "";

    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS emp_details (emp_id INT PRIMARY KEY, name VARCHAR(50), department VARCHAR(50), salary DOUBLE)");

        if (action != null) {
            int empId = Integer.parseInt(request.getParameter("empId"));
            String name = request.getParameter("name");
            String dept = request.getParameter("department");
            String salary = request.getParameter("salary");

            if (action.equals("Add")) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO emp_details VALUES (?, ?, ?, ?)");
                ps.setInt(1, empId);
                ps.setString(2, name);
                ps.setString(3, dept);
                ps.setDouble(4, Double.parseDouble(salary));
                ps.executeUpdate();
                message = "Employee " + empId + " added successfully.";
            } else if (action.equals("Update")) {
                PreparedStatement ps = con.prepareStatement("UPDATE emp_details SET name = ?, department = ?, salary = ? WHERE emp_id = ?");
                ps.setString(1, name);
                ps.setString(2, dept);
                ps.setDouble(3, Double.parseDouble(salary));
                ps.setInt(4, empId);
                int rows = ps.executeUpdate();
                message = rows > 0 ? "Employee " + empId + " updated successfully." : "Employee " + empId + " not found.";
            } else if (action.equals("Delete")) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM emp_details WHERE emp_id = ?");
                ps.setInt(1, empId);
                int rows = ps.executeUpdate();
                message = rows > 0 ? "Employee " + empId + " deleted successfully." : "Employee " + empId + " not found.";
            }
        }
%>
    <p class="msg"><%= message %></p>
    <h3>Employee Records</h3>
    <table>
        <tr><th>Employee ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
<%
        ResultSet rs = st.executeQuery("SELECT * FROM emp_details ORDER BY emp_id");
        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getInt("emp_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
        </tr>
<%
        }
%>
    </table>
<%
    } catch (Exception e) {
        out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
    }
%>
</body>
</html>
