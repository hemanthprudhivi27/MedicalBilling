<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form action="update.htm" method = "post">
   
    <h1><p>Update the Medicines</p></h1>
  
     <label for="Medicine_name"><b>Medicine_name</b></label>
     <input type="text" placeholder="Medicine_name" name="medicinename" required>

     <label for="No_of_medicines"><b>No_of_medicines</b></label>
     <input type="text" placeholder="Enter No_of_medicines" name="quantity" required>   

     <label for="submit"><b>Next</b></label>
     <input type = "submit" name = "submit">

</form>
  
  <form action="finish.htm" method = "post">
 
   <label for="submit"><b>Finish</b></label>
   <input type = "submit" name = "submit">
     
</form>  
</body>
</html>