<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>직원 한 명 조회</title>
</head>
<body>
  <jsp:include page="../common/header.jsp"/>
  사원 번호 : ${requestScope.selectedEmp.empId}<br>
  사원명 : ${requestScope.selectedEmp.empName}<br>
  부서번호 : ${requestScope.selectedEmp.deptCode}<br>
  직급코드 : ${requestScope.selectedEmp.jobCode}<br>
  급여 : ${requestScope.selectedEmp.salary}<br>
</body>
</html>