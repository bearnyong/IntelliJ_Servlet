package com.study.section03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*3.3. Request Listener*/
@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet/*a태그를 호출하기에 doGet*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*request에 Listener의 attributeAdded 메서드가 호출된다.*/
        req.setAttribute("username", "honggildong");
        req.setAttribute("age", 20);
        req.setAttribute("gender", "m");

        /*request에 Listener의 attributeReplaced 메서드가 호출된다.*/
        req.setAttribute("username", "hong");

        /*request에 Listener의 attributeRemoved가 호출된다.*/
        req.removeAttribute("gender");
    }
}
