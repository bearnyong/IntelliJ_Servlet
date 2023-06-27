<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Request Prameter</h1>
<h3>GET 방식의 요청</h3>
<h4>form 태그를 이용한 get 방식 요청</h4>
<form action="querystring" method="get">
    <label>이름 : </label> <input type="text" name="name"> <br>
    <label>나이 : </label> <input type="text" name="age"> <br>
    <label>생일 : </label> <input type="date" name="birthday"> <br>
    <label>성별 : </label> <input type="radio" name="gender" id="male" value="M"><label for="male">남자</label>
                 </label> <input type="radio" name="gender" id="female" value="W"><label for="female">여자</label> <br>
    <label>국적 : </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select> <br>
    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"> <label for="movie">영화</label>
    <input type="checkbox" name="hobbies" id="music" value="music"> <label for="music">음악</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep"> <label for="sleep">취침</label>
    <input type="submit" value="GET 요청 전송">
</form>
<a href="http://localhost:8080/querystring?name=%EA%B3%A0%EB%AF%BC%EC%98%81&age=215&birthday=2023-06-22&gender=W&national=ko&hobbies=movie">queryString</a>

<h4>form 태그를 이용한 post 방식 요청</h4>
<form action="formdata" method="post">
    <label>이름 : </label> <input type="text" name="name"> <br>
    <label>나이 : </label> <input type="text" name="age"> <br>
    <label>생일 : </label> <input type="date" name="birthday"> <br>
    <label>성별 : </label> <input type="radio" name="gender" id="m" value="M"><label for="m">남자</label>
                 <input type="radio" name="gender" id="f" value="W"><label for="f">여자</label> <br>
    <label>국적 : </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select> <br>
    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie1" value="movie"> <label for="movie1">영화</label>
    <input type="checkbox" name="hobbies" id="music1" value="music"> <label for="music1">음악</label>
    <input type="checkbox" name="hobbies" id="sleep1" value="sleep"> <label for="sleep1">취침</label>
    <input type="submit" value="POST 요청 전송">
</form>
</body>
</html>