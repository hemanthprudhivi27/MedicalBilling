<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register.htm" method = "post">
  
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="username"><b>User_name</b></label>
    <input type="text" placeholder="Enter username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="phone"><b>Phone</b></label>
    <input type="text" placeholder="Enter Phone" name="phone" required>
    
    <input type="radio" name="select" value="1">Admin<br>
    <input type="radio" name="select" value="0"> User<br>
    <hr>
    <label for="submit"><b>submit</b></label>
    <input type="submit" name="submit" required>
    <hr>
   
  
</form> 
<form action="login.htm" method = "post">
  
    <label for="username"><b>User_name</b></label>
    <input type="text" placeholder="Enter username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
</form>
</body>
</html>