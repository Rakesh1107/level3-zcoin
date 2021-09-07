<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
</head>
<body>

<form action="http://localhost:8080/ZCoin/controller?page=change-password" method="post">
<label>HID</label>
<input type="number" name="hid">
<label>Old password</label>
<input type="password" name="old-password">
<label>New password</label>
<input type="password" name="new-password">
<input type="submit" value="change password">
</form>


</body>
</html>