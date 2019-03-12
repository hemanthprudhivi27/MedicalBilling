<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BILL </h1>

<tr><c:forEach items="${medicines}" var="hi">
    <c:forEach items="${hi}" var="entry">
        ${entry.key}<br>
        ${entry.value}<br>
    </c:forEach>
</c:forEach>
<c:forEach items="${Rupees}" var="h">
    <c:forEach items="${h}" var="entry">
        ${entry.key}<br>
        ${entry.value}<br>
    </c:forEach>
</c:forEach></tr>
<tr><h2>Total_amount :</h2>
<% out.println(request.getAttribute("Total_amount")); %></tr>
</body>
</html>