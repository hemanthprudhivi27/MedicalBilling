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
<h1><p> Medicine list</p></h1>
<tr>
<c:forEach items="${Total_medicine}" var="l">
    ${l}<br>
</c:forEach>
</tr>
<h1><p>Type the medicines which you want</p></h1>
<form action= "select_medicines.htm" method = "post">

     <label for="Medicine_name"><b>Medicine_name</b></label>
     <input type="text" placeholder="Medicine_name" name="medicinename" required>

     <label for="No_of_medicines"><b>No_of_medicines</b></label>
     <input type="text" placeholder="Enter No_of_medicines" name="quantity" required>   
     
    <input type="radio" name="select" value="next">Next<br>
    <input type="radio" name="select" value="finish">Finish<br>

     <label for="submit"><b>OK</b></label>
     <input type = "submit" name = "submit">


</form>
</body>
</html>