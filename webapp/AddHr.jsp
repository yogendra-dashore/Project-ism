<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddHr</title>

<style>
.color{
   color:red;
}
</style>

</head>
<body align="center">

<% 
String hrname = (String)request.getAttribute("hrname");
String hremail = (String)request.getAttribute("hremail");
String hrpassword = (String)request.getAttribute("hrpassword");
String hrmobno = (String)request.getAttribute("hrmobno");
%>

<form action="HrRegistrationController" method="post">
Enter Hr Name : <input type="text" name="hrname" value="${hrnamevalue}"/>
<span class="color"><%= hrname==null?"":hrname%></span><br><br>
Enter Hr Email : <input type="text" name="hremail" value="${hremailvalue }"/>
<span class="color"><%= hremail==null?"":hremail%></span><br><br>
Enter Hr Password : <input type="text" name="hrpassword" value="${hrpasswordvalue}"/>
<span calss="color"><%= hrpassword==null?"":hrpassword %></span><br><br>
Enter Hr MobileNo : <input type="text" name="hrmobno" value="${hrmobnovalue}"/>
<span calss="color"><%= hrmobno==null?"":hrmobno %></span><br><br>

<input type="submit" value="Submit"/>

</form>


</body>
</html>