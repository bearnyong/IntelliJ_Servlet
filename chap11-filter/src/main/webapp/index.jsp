<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Filter</title>
</head>
<body>
    <ul>
        <li><a href="/first/filter">filter 사용하기</a></li>
    </ul>
    <h3>필터의 활용</h3>
    <form action="member/regist" method="post">
        <dev>
            <label>아이디 : </label>
            <input type="text" name="userId"/>
        </dev>
        <dev>
            <label>비밀번호 : </label>
            <input type="password" name="password"/>
        </dev>
        <dev>
            <laber>이름 : </laber>
            <input type="text" name="name"/>
        </dev>
        <button type="submit">가입하기</button>
    </form>
</body>
</html>