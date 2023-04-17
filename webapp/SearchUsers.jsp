<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Users</title>
</head>
<body align="center">

<h2>Search By Name</h2>
       
       <%String msg = (String)request.getAttribute("msg"); %>

<span class="color"><%=msg==null?"":msg %></span><br>
       
       <form action="SearchUsersController" method="post">
          Enter Name :- <input type="text" name="name"/>
          <input type="submit" value="SEARCH"/>
       </form>

</body>
</html>