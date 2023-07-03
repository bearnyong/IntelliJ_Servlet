package com.study.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionhandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        //index.jsp에서 정상적으로 값이 넘어왔는지 확인해보기
        System.out.println(firstName);
        System.out.println(lastName);

        /* 이전 챕터에서는 값을 유지하기 위한 기술로 쿠키를 사용했다.
        *  하지만 쿠키의 보안상 단점과 지원하지 않는 브라우저 문제 등으로 상태를 유지해야하는 메커니즘에 적합하지 않은 경우가 다수이다.
        *  특히 회원 정보를 이용해서 해당 회원의 로그인 상태를 지속적으로 유지해야하는 경우가 특히 그렇다.
        *  따라서 서버쪽에서 조금 더 안전하게 관리되는 세션이라는 인스턴스를 이용해서 상태를 유지하는 메커니즘을 제공하고 있다.
        *  httpSession은 직접 생성할 수 없고 request에 있는 getSetssion() 메소드를 이용해서 리턴받는다. */

        HttpSession session = req.getSession();

        /* 보통 로그인의 경우 30분의 시간을 주는데 이는 session의 기본 시간이 30분이기 때문이다. */
        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60*100); //세션 만료 시간을 10분으로 설정
        System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());

        System.out.println("session-id : " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        //redirect는 값 이동 x... 일단 이렇게 이해해보기...
        resp.sendRedirect("redirect");

    }
}
