<%@page import="com.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%AdminBean adminBean=(AdminBean)request.getAttribute("adminBean"); %>
<%=adminBean.getEmail() %>

<a href="AddHr.jsp">Add Hr</a>
<a href="HrListController">Hr List</a>
<a href="">Resource List</a>

</body>
</html>