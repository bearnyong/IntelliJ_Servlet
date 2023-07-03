package com.study.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet/*a 태그로 불러오는 요청은 doGet!!*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* session은 서버에 저장되는 데이터이다. (쿠키:사용자 , 세션:서버) */
        /* 요청한 사용자의 session 데이터를 확인하기 위한 로직 */
        HttpSession session = req.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        /* 필기 */

        /* 시간 만료 */
        session.setMaxInactiveInterval(0);

        /* 속성 삭제 */
        session.removeAttribute("firstName"); //값 지우기
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        /* 세션 자체를 무효화 하는 것으로 아래의 코드에서 에러가 발생한다. */
        session.invalidate(); //세션 무효화
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }
    }
}
