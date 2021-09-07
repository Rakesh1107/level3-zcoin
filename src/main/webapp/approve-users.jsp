
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="base.Customer"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZCoin</title>
</head>
<body>
     
       
    <c:forEach items="${data}" var="user">
  
    <form action="http://localhost:8080/ZCoin/controller?page=approve-user" method="post">
    
	${user.getFullName()}
    ${user.getEmailId()}
    ${user.getMobileNumber()}
    ${user.gethID()}
    <input type="number" name="hid">
    <input type = "submit" value="Approve">
    
    </form>
</c:forEach>

</body>
</html>