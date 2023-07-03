package com.study.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerSevlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*인코딩 설정*/
        req.setCharacterEncoding("UTF-8");

        /* 사용자의 요청 값을 꺼내온다. */
        //index.jsp의 firstName값과 lastName값 받아오기
        String firstName = req.getParameter("firstName"); 
        String lastName = req.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        /* 쿠키를 사용하는 방법은 간단하다.
         *  1. 쿠키를 생성한다. Cookie 변수명 = new Cookie("key", 값);
         *  2. 생성한 쿠키의 만료시간을 설정한다. 변수명.setMaxAge(시간); 초 단위로 계산됨
         *  3. 응답 헤더에 쿠키를 담는다. resp.addCookie(값)
         *  4. 응답을 보낸다.
         *
         * 쿠키는 일부 제약사항이 있다.
         * 쿠키의 이름은 ascii 문자만을 사용해야 하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
         * 또한 쿠키의 이름에는 공백문자와 일부 특수문자 ([ ] ( ) = , " \ ? @ : ; )를 사용할 수 없다. */

        /* 요청 값을 쿠키에 담아준다. key,value */
        Cookie firstCookie = new Cookie("firstName", firstName);
        Cookie lastCookie = new Cookie("lastName", lastName);

        /* 쿠키의 만료 시간을 설정한다. 이후 쿠키는 삭제된다. */
        firstCookie.setMaxAge(60*60*24); //초 단위 (하루)
        lastCookie.setMaxAge(60*60*24);

        /* 사용자 응답시 쿠키의 값을 담아서 보낸다. */
        //응답할 때 쿠키 정보 심어주고 담아주기
        resp.addCookie(firstCookie);
        resp.addCookie(lastCookie);

        /* 쿠키에 담긴 값 읽어오기 */
        resp.sendRedirect("redirect");

    }
}
