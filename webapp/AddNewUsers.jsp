<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddNewUsers</title>	
</head>
<body align="center">
   <%
String name =(String) request.getAttribute("name");
String email =(String) request.getAttribute("email");
String mobno = (String)request.getAttribute("mobno");
String[] language =(String[]) request.getAttribute("language"); 
String[] database =(String[]) request.getAttribute("database");
String[] technology = (String[])request.getAttribute("technology");
String experience = (String)request.getAttribute("experience");
String resumeurl =(String) request.getAttribute("resumeurl");
String qualification = (String)request.getAttribute("qualification");
%>
<h1>Form For Add New Resource</h1>

<form action="AddNewUsersController" method="post">

Enter Name : <input type="text" name="name" placeholder="Enter Name"/><br><br>
Enter Email : <input type="text" name="email" placeholder="Enter Email"/><br><br>
Enter ContactNo : <input type="text" name="cono" placeholder="Enter ContactNo"/><br><br>


<label for="language">Select Language : </lable>

         <select name="language" id="language" multiple="multiple" required>
         <option value="C">C</option>
         <option value="C#">C#</option>
         <option value="Java">Java</option>
         <option value="PHP">PHP</option>
         <option value="Python">Python</option>
         <option value="Ruby">Ruby</option> 
         
</select><br><br>

<label for="database">Select Database :-</label>

         <select name="database" id="database" multiple="multiple" required>
         <option value="Oracle DB">Oracle DB</option>
         <option value="MSSQL">MSSQL</option>
         <option value="MangoDB">MangoDB</option>
         <option value="MYSQL">MYSQL</option>
                  
 </select>  <br><br>

<label for="technology">Select Technology : </label>

<select name="technology" id="technology" multiple="multiple" required>

          <option value="C">C</option>
          <option value="C#">C#</option>
          <option value="Java">Java</option>
          <option value="PHP">PHP</option>
          <option value="C">C</option>
          <option value="Python">Python</option>
          <option value="Ruby">Ruby</option>


</select>  <br><br>

 Enter Experience :- <input type="text" name="experience" placeholder="Experience In Yr"/><br><br>
 Enter Resume URL :- <input type="text" name="resumeurl" placeholder="Experience In Yr"/><br><br>
 Enter Qualification : <input type="text" name="qualification" placeholder="Enter Qualification">        
          
          <input type="submit" values="SUBMIT"/>
          
</form>

</body>
</html>