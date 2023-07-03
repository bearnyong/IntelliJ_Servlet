package com.study.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // CookieHandlerSevlet클래스에서 담겨진 값 가져오기
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        // null (redirect : 요청 자체를 새로운 요청으로 보기 때문에 값 전달이 안된다.)
        System.out.println(firstName);
        System.out.println(lastName);

        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie]" + cookies[i].getName()/*키*/ + " : " + cookies[i].getValue()/*값*/);

            if("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            }else if("lastName".equals(cookies[i].getName())){
                lastName = cookies[i].getValue();
            }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("<title>Cookie</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1> cookie Test </h1>")
                .append(firstName)
                .append(" and last name is ")
                .append(lastName)
                .append("</body>")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print(responseText.toString());
        out.flush();
        out.close();

        /* 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다.
         * 그렇기 때문에 개인 pc는 크게 상관 없지만 공용 pc 등 다른 사용자와 함께 쓰는 컴퓨터이면(민감한 개인정보를 포함한 경우) 보안에 취약하다.
         * 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는 세션을 이용한다.
         * 세션은 쿠키와 유사한 형태로 key= value 쌍으로 저장되지만 서버(톰캣)에서 관리가 되어 보안이 보다 우수하다는 장점을 가진다.*/

    }
}
