<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditHr</title>
</head>
<body align="center">

<form action="EditHrController" method="post">
    
    <input type="hidden" name="hrid" value="${param.id}"/> 
      Enter HrName :- <input type="text" name="hrname" value="${hrBean.hrname }" /><br><br>
      Enter HrEmail :-  <input type="text" name="hremail" value="${hrBean.hremail}"/><br><br>
      Enter HrPass :-   <input type="password" name="hrpassword" value="${hrBean.hrpassword}"/><br><br>
      Enter HrMob :- <input type="text" name="hrmobno" value="${hrBean.hrmobno}"/><br><br>
      
      <input type="submit" value="UPDATE"/>
    </form>


</body>
</html>