<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>forward</title>
</head>
<body>
<h1>forward</h1>
<form action="forward" method="post">
    <table>
        <tr>
            <th>아이디 :</th>
            <td><input type="text" name="userId"></td>
            <td rowspan="2"><button type="submmit" style="height: 50px">로그인</button> </td>
        </tr>
        <tr>
            <td>비밀번호 : </td>
            <td> <input type="password" name="password"></td>
        </tr>
    </table>
</form>
</body>
</html>