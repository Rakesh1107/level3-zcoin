<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZCoin Application</title>
</head>
<body>


    <form action="http://localhost:8080/ZCoin/controller?page=user-signup" method="post">
        <label>Full name</label>
        <input type="text" name="name"><br>
        <label>Email id</label>
        <input type="email" name="email"><br>
        <label>Mobile number</label>
        <input type="number" name="mobile"><br>
        <label>H ID</label>
        <input type="number" name="hid"><br>
        <label>Password</label>
        <input type="password" name="password"><br>
        <label>Initial deposit</label>
        <input type="number" name="deposit"><br>
        
        <input type="submit">
    </form>

</body>
</html>