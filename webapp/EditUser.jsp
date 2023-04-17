<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="EditUsersController" method="post">
             
           <input type="hidden" name="id" value="${param.id}" /> 
          Enter Name :- <input type="text" name="name" value="${resourceBean.name }"/> <br><br>
          Enter Email :- <input type="text" name="email" value="${resourceBean.email }"/><br><br>
          Enter Mobno :- <input type="text" name="mobno" value="${resourceBean.mobno }"/><br><br>
          Enter Experience :- <input type="text" name="experience" value="${resourceBean.experience }"/><br><br>
          Enter Qualification :- <input type="text" name="qualification" value="${resourceBean.qualification }"/><br><br>
          Enter Resume URL :- <input type="text" name="resumeurl" value="${resourceBean.resumeurl }"/><br><br>
          
          <input type="submit" value="UPDATE"/>
         </form>

</body>
</html>