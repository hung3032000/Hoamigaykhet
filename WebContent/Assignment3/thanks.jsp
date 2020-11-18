<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirm</title>
</head>
<body>
	<h1>Order Confirmation</h1>
	<p>Thank you for your order <%= request.getParameter("quantity") %> widgets, <%= request.getParameter("customerName") %></p>
	<p>At $<%= (String)request.getAttribute("defaultCost") %>, your bill will be $<%= (String)request.getAttribute("totalCost")%></p>
	<p>You will shortly receive an email confirmation at <%= request.getParameter("customerEmail") %></p>
	<p>Please follow  <a href="Assignment3/index.jsp">this link</a>to go back</p>
</body>
</html>