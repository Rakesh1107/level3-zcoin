<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZCoin Application</title>
</head>
<body>
<form action="http://localhost:8080/ZCoin/controller?page=user-login" method="post">
        <label>HID</label>
        <input type="number" name="hid"><br>
        <label>Password</label>
        <input type="password" name="password">
        
        <input type="submit">
    </form>

</body>
</html>