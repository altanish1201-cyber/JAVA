<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");

    String maskedPassword = "";
    for (int i = 0; i < password.length(); i++) {
        maskedPassword += "*";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; }
        td, th { border: 1px solid #555; padding: 8px 14px; text-align: left; }
    </style>
</head>
<body>
    <h2>Registration Successful!</h2>
    <p>Welcome, <b><%= name %></b>. Your details are:</p>
    <table>
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>Email</th><td><%= email %></td></tr>
        <tr><th>Phone Number</th><td><%= phone %></td></tr>
        <tr><th>Password</th><td><%= maskedPassword %> (<%= password.length() %> characters)</td></tr>
    </table>
    <p><a href="UserRegistration.jsp">Register another user</a></p>
</body>
</html>
