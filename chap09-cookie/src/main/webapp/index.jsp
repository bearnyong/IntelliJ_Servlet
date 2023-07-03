<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie handling</title>
</head>
<body>
<h1>Cookie Handling</h1>
<%-- action ="서블릿 url을 입력" method = "데이터 전송방식"    --%>
<form action="cookie" method="post">
    <table>
        <tr>
            <th>firstName : </th>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <th>lastName : </th>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">전송</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>