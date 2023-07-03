<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%----%>
    <script type="text/javascript">
        (function (){
            <%--자바스크립트 변수 const, let, var(사용x)--%>
            const  successCode = '${requestScope.successCode}';
            let successMessage = '';
            let movePath = '';
            switch (successCode){
                case '직원 등록 성공' :
                    movePath = '${pageContext.servletContext.contextPath}/employee/list';
                    break;

                case '직원 정보 수정 성공' :
                    movePath = '${pageContext.servletContext.contextPath}/employee/list';
                    break;
            }
            alert(successCode); <%--대기스택--%>
            location.href = movePath; <%--확인 누른 후 저기로 이동...--%>
        })(); <%--정의하고 괄호 닫아주면 바로 실행 되는 것...--%>

    </script>
</body>
</html>
