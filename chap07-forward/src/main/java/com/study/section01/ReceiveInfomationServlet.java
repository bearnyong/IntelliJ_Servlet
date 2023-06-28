package com.study.section01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInfomationServlet extends HttpServlet {

    /* 리다이렉트 : chap08 참고 (나에게 들어온 요청을 다른 사람에게 전달 -> 어쩌공...)
    * 포워드 : 실제 동작은 PrintLoginSuccessServlet에서 실행되었지만 forward에서 실행된 것처럼 보이게 한다는 느낌... */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        userId = "로그인 완료됨";

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);

        req.setAttribute("userId", userId);
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);

    }
}
