<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body align="center">

<%
String email = (String)request.getAttribute("email");
String password = (String)request.getAttribute("password");
%>
<form action="AdminAuthenticationController" method="post">
Enter Email : <input type="text" name="email" value="${emailvalue }"/>
<span class="color"><%=email==null?"":email%></span><br><br>
Enter password : <input type="text" name="password" value="${passwordvalue }"/>
<span class="color"><%=password==null?"":password%></span>



<input type="submit" value="Login"/>
</form>


</body>
</html>