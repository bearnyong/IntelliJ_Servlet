package com.study.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*2.3. session Listener
* 리스너는 일어나는 행위를 감지하는 것이기 때문에...
* 예상했던 행위들에 대한 이벤트를 감지할 때 리스너 발생 (ex.context에 등록되는 행위 감지, 뭐시깽이 등록되는 행위 감지, ...*/
@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet/*a태그 요청이므로 doGet*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("발급받은 session ID : " + session.getId());

        /*세션에 값 넣어주기*/
        session.setAttribute("username", "honggildong");
        session.setAttribute("age", 20);
        session.setAttribute("gender", "M");

        session.setAttribute("user", new UserDTO("honggildong", 20));

        /*SessionListenerTest.attributeReplaced(수정) : (honggildong에서 hong으로 이름 수정)*/
        session.setAttribute("username", "hong");

        /*SessionListenerTest.attributeRemoved(속성 제거)*/
        session.removeAttribute("gender");

//        /*SessionListenerTest.sessionDestroyed(제거)*/
//        session.invalidate();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>접자 확인</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>접자 확인 : " + SessionListenerTest.userCnt + "</h1>");
        out.print("</body>");
        out.print("</html>");

        out.flush();
        out.close();

    }
}
