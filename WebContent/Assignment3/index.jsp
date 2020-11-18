<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ass3" method="GET">
    <h1>Widget Order Form</h1>
    <p>Number of purchase: <input type="text" name="quantity"></p>
    <p>Your name: <input type="text" name="customerName"></p>
    <p>Your email: <input type="text" name="customerEmail"></p>
    <input type="submit" value="Place Order">
    </form>
</body>
</html>