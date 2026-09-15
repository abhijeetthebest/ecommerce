<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Test Page</h1>
    <p>This is a simple test page to verify that JSP is working correctly.</p>
    <p>Current time: <%= new java.util.Date() %></p>

    <h2>Links</h2>
    <ul>
        <li><a href="index.html">Home Page</a></li>
        <li><a href="customer/simpleCustomerView.jsp">Customer Management</a></li>
        <li><a href="customer/simpleOrderHistory.jsp">Order History</a></li>
        <li><a href="customer/simpleAddOrderHistory.jsp">Add Order History</a></li>
    </ul>
</body>
</html>
