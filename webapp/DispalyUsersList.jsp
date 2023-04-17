<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList"  import="com.bean.ResourceBean"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">

<%ArrayList<UserBean> resourceBeanAL =(ArrayList<UserBean>) request.getAttribute("userBeanAL"); %>
     <h2>List Of All Resource</h2>
      <a href="SearchUsers.jsp">Search</a><br><br>
     <table border="1" align="center">
          <tr>
             <th>Id</th>
             <th>Name</th>
             <th>Email</th>
             <th>Mobno</th>
             <th>Experience</th>
             <th>ResumeURL</th>
             <th>Qualification</th>
             <th>Action</th>
            
             
          </tr>
          <%
              for(UserBean rb:resourceBeanAL) {
          %>
          <tr>
             <td><%=rb.getId() %></td>
             <td><%=rb.getName() %></td>
             <td><%=rb.getEmail() %></td>
             <td><%=rb.getMobno() %></td>
             <td><%=rb.getExperience() %></td>
             <td><%=rb.getResumeurl() %></td>
             <td><%=rb.getQualification() %></td>
             <td>
                 <a href="ViewLanguageController?id=<%=rb.getId() %>">Language</a>
                 |
                  <a href="ViewDatabaseController?id=<%=rb.getId() %>">Database</a>
                  |
                   <a href="ViewTachnologyController?id=<%=rb.getId() %>">Tachnology</a>
                  |
                  <a href="EditUsersController?id=<%=rb.getId() %>">Update</a>
                  |
                  <a href="ViewUsersController?id=<%=rb.getId() %>">View</a>
                  |
                  <a href="DeleteController?id=<%=rb.getId() %>">Delete</a>
                 </td>
          </tr>
          <%
              }
          %>
     </table>

</body>
</html>