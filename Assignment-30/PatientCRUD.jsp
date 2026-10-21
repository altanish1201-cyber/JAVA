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
    <title>Patient Records</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; }
        td, th { border: 1px solid #555; padding: 6px 12px; }
        .form td { border: none; }
        input, select { padding: 4px; }
        .msg { color: green; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Hospital Patient Record Management</h2>
    <form method="post" action="PatientCRUD.jsp">
        <table class="form">
            <tr><td>Patient ID</td><td><input type="number" name="patientId" required></td></tr>
            <tr><td>Name</td><td><input type="text" name="name"></td></tr>
            <tr><td>Age</td><td><input type="number" name="age" min="0" max="120"></td></tr>
            <tr><td>Disease</td><td><input type="text" name="disease"></td></tr>
            <tr><td>Treatment Status</td>
                <td>
                    <select name="status">
                        <option>Admitted</option>
                        <option>Under Treatment</option>
                        <option>Recovered</option>
                        <option>Discharged</option>
                    </select>
                </td>
            </tr>
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
        st.executeUpdate("CREATE TABLE IF NOT EXISTS patient (patient_id INT PRIMARY KEY, name VARCHAR(50), age INT, disease VARCHAR(50), treatment_status VARCHAR(30))");

        if (action != null) {
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String disease = request.getParameter("disease");
            String status = request.getParameter("status");

            if (action.equals("Add")) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO patient VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, patientId);
                ps.setString(2, name);
                ps.setInt(3, Integer.parseInt(age));
                ps.setString(4, disease);
                ps.setString(5, status);
                ps.executeUpdate();
                message = "Patient " + patientId + " added successfully.";
            } else if (action.equals("Update")) {
                PreparedStatement ps = con.prepareStatement("UPDATE patient SET name = ?, age = ?, disease = ?, treatment_status = ? WHERE patient_id = ?");
                ps.setString(1, name);
                ps.setInt(2, Integer.parseInt(age));
                ps.setString(3, disease);
                ps.setString(4, status);
                ps.setInt(5, patientId);
                int rows = ps.executeUpdate();
                message = rows > 0 ? "Patient " + patientId + " updated successfully." : "Patient " + patientId + " not found.";
            } else if (action.equals("Delete")) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM patient WHERE patient_id = ?");
                ps.setInt(1, patientId);
                int rows = ps.executeUpdate();
                message = rows > 0 ? "Patient " + patientId + " deleted successfully." : "Patient " + patientId + " not found.";
            }
        }
%>
    <p class="msg"><%= message %></p>
    <h3>Patient Records</h3>
    <table>
        <tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th></tr>
<%
        ResultSet rs = st.executeQuery("SELECT * FROM patient ORDER BY patient_id");
        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
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
