package com.study.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 서블릿의 역할
        *  1. 클라이언트의 요청을 받는다 . -http method GET/POST 요청에 따라 parameter로 전달받은 데이터를 꺼내올 수 있다.
        *     (chap4-prameter 참고)
        *  2. 비즈니스 로직 처리 = DB접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결한다. (MVC)
        *  3. 응답하기 -> 문자열로 동적인 웹(html) 페이지를 만들고 스트림을 이용해 내보낸다.
        *
        *  http 통신의 동작 : 기본 text 데이터를 전송 -> 브라우저 해석 -> 돔트리를 생성함 */

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html> \n")
                .append("<head> \n")
                .append("<title> 소임 바보 </title>")
                .append("</head>")
                .append("<body> \n")
                .append("<h1>작성자 : 고민영</h1> \n")
                .append("</body>")
                .append("</html>");

        /* 클라이언트에게 내보낼 데이터의 타입을 응답 헤더에 설정해준다.
        *  이 때 설정된 값은 content-type 헤더의 설정을 해주어야하며 설정하지 않으면 text/plain으로 설정된다. */

        // 설정하지 않았을 때의 값 확인해보기
        System.out.println("default reponse type : " + resp.getContentType());

        /* 기본값은 text/plain이나 html 태그를 사용하면 요청 시 text/html도 응답을 수락 가능하도록 헤더 설정이 되어 있다.
        *  그래서 자동으로 text/html로 인식한다. 하지만 text/plain으로 설정하게 되면 html 태그를 태그로 인식하지 않고 문자열로 인식한다. */
        resp.setContentType("text/html");

        /**/
        resp.setCharacterEncoding("UTF-8");
        System.out.println("changed response encoding : " + resp.getCharacterEncoding());

        PrintWriter out = resp.getWriter();

        /* 스트림으로 데이터를 내보낸다. */
        out.print(responseBuilder.toString());
        out.flush(); //남아있는 데이터를 내보내준다.
        out.close();

    }

}
