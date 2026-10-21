<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%!
    private int visitCount = 0;

    private String getGrade(int marks) {
        if (marks >= 90) return "O";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "F";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; }
        td, th { border: 1px solid #555; padding: 8px 14px; text-align: left; }
        input, select { padding: 4px; width: 200px; }
    </style>
</head>
<body>
    <h2>Student Information Form</h2>
    <form method="post" action="StudentInfo.jsp">
        <table>
            <tr><td>Name</td><td><input type="text" name="name" required></td></tr>
            <tr><td>PRN</td><td><input type="text" name="prn" required></td></tr>
            <tr><td>Branch</td>
                <td>
                    <select name="branch">
                        <option>CSE</option>
                        <option>IT</option>
                        <option>ENTC</option>
                        <option>Mechanical</option>
                    </select>
                </td>
            </tr>
            <tr><td>Semester</td><td><input type="number" name="semester" min="1" max="8" required></td></tr>
            <tr><td>Marks (out of 100)</td><td><input type="number" name="marks" min="0" max="100" required></td></tr>
            <tr><td colspan="2"><input type="submit" value="Submit"></td></tr>
        </table>
    </form>

<%
    String name = request.getParameter("name");
    if (name != null) {
        visitCount++;
        String prn = request.getParameter("prn");
        String branch = request.getParameter("branch");
        String semester = request.getParameter("semester");
        int marks = Integer.parseInt(request.getParameter("marks"));
%>
    <h3>Submitted Student Details</h3>
    <table>
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>PRN</th><td><%= prn %></td></tr>
        <tr><th>Branch</th><td><%= branch %></td></tr>
        <tr><th>Semester</th><td><%= semester %></td></tr>
        <tr><th>Marks</th><td><%= marks %></td></tr>
        <tr><th>Grade</th><td><%= getGrade(marks) %></td></tr>
    </table>
    <p>Submitted on: <%= new Date() %></p>
    <p>Total submissions on this page: <%= visitCount %></p>
<%
    }
%>
</body>
</html>
