<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>직원 한 명 조회</title>
</head>
<body>
  <jsp:include page="../common/header.jsp"/>
  <%-- requestScope.속성명(response의 정의된 속성).(클래스인 경우 필드명)
       response의 대한 응답은 컨트롤러에서 대부분 처리한다(MVC디자인 패턴 이용) --%>
  사원 번호 : ${requestScope.selectedEmp.empId}<br> <%--selectedEmp 안의 empId 값 꺼내오기...--%>
  사원명 : ${requestScope.selectedEmp.empName}<br>
  부서번호 : ${requestScope.selectedEmp.deptCode}<br>
  직급코드 : ${requestScope.selectedEmp.jobCode}<br>
  급여 : ${requestScope.selectedEmp.salary}<br>
</body>
</html>