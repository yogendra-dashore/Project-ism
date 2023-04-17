<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList" import="com.bean.HrBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayHrList</title>
</head>
<body align="center">

<% ArrayList<HrBean> hrBeanAL = (ArrayList<HrBean>)request.getAttribute("hrBeanAL"); %>

<a href="Search.jsp">Search</a> <br><br>

<table border = "1" align="center">
<tr>
<th>HrId</th>
<th>HrName</th>
<th>HrEmail</th>
<th>HrPass</th>
<th>HrMobno</th>
<th>Action</th>

</tr>

<% 

for(HrBean user : hrBeanAL){

%>

<tr>
            <td><%=user.getId()%></td>
            <td><%=user.getHrname()%></td>
            <td><%=user.getHremail()%></td>
            <td><%=user.getHrpassword()%></td>
            <td><%=user.getHrmobno()%></td>
            <td><a href="DeleteHrController?id=<%=user.getId()%>">Delete</a>
            |
            <a href="EditHrController?id=<%=user.getId()%>">Edit</a>
            |
            <a href="ViewHrController?id=<%=user.getId()%>">View</a>
            </td>
            
           
         </tr>
        <% } %>



</body>
</html>