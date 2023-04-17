<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% ArrayList languageAL = (ArrayList) request.getAttribute("languageAL");
       ArrayList databaseAL = (ArrayList) request.getAttribute("databaseAL");
       ArrayList technologyAL = (ArrayList) request.getAttribute("technologyAL");
        String check = (String) request.getAttribute("check");
    %>
    
   
       
      
       <pre>
        <%if(check.equals("Language")) {%>
        <h1>  Languages Details  </h1> 
            <%Iterator e = languageAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %> 
         <%} %>
      
       <% if(check.equals("Database")) {%>
       
       <h1>  Database Details  </h1> 
            <%Iterator e = databaseAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %>
              
       <%} %>
       
       
        <% if(check.equals("Tachnology")) {%>
       
       <h1>  Database Details  </h1> 
            <%Iterator e = technologyAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %>
              
       <%} %>
       
          
           
       </pre>
     
    </table>

</body>
</html>