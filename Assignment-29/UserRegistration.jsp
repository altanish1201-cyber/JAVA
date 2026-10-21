<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        td { padding: 6px 10px; }
        input { padding: 4px; width: 220px; }
    </style>
</head>
<body>
    <h2>User Registration Form</h2>
    <form method="post" action="RegistrationResult.jsp">
        <table>
            <tr><td>Name</td><td><input type="text" name="name" required></td></tr>
            <tr><td>Email</td><td><input type="email" name="email" required></td></tr>
            <tr><td>Phone Number</td><td><input type="text" name="phone" pattern="[0-9]{10}" title="Enter a 10 digit number" required></td></tr>
            <tr><td>Password</td><td><input type="password" name="password" minlength="6" required></td></tr>
            <tr><td></td><td><input type="submit" value="Register"></td></tr>
        </table>
    </form>
</body>
</html>
