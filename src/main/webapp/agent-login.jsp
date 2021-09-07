<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent Login</title>
</head>
<body>
 <form action="http://localhost:8080/ZCoin/controller?page=agent-login" method="post">
        <label>User name</label>
        <input type="text" name="name"><br>
        <label>Password</label>
        <input type="password" name="password">
        
        <input type="submit">
    </form>
</body>
</html>