package com.study.section01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*1.3. context Listener*/
@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet/*a태그로 불러오기 때문에 doGet*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("context Listener 확인용 서블릿");

        ServletContext context = req.getServletContext();
        /*context attr를 추가하면 attributeAdded()가 동작한다.*/
        context.setAttribute("test", "value");
        /*동일한 key context에 attr를 추가하면(수정) attributeReplaced() 메소드가 동작한다.*/
        context.setAttribute("test", "value2");
        /*context에서 attr를 제거하면 attributeRemoved() 메소드가 동작한다.*/
        context.removeAttribute("test");

    }
}
