<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
.color{
color:red;
}
</style>
</head>
<body align="centre">

<%String error = (String)request.getAttribute("error"); %>

<span class="color"><%=error==null?"":error %></span><br><br>

<form action="HrAuthenticationController" method="post">
Enter Email : <input type="text" name="hremail" placeholder="Enter Email"/><br><br>
Enter Password : <input type="password" name="hrpassword" placeholder="Enter password"/><br><br>

<input type="submit" value="Login"/>
</form>
</body>
</html>