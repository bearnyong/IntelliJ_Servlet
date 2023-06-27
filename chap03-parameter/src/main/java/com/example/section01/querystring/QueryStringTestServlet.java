package com.example.section01.querystring;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    public QueryStringTestServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); //querystring?name=값
        System.out.println("name Parameter : " + name);

        int age = Integer.parseInt(req.getParameter("age")); //쿼리 파라미터 값은 전부 스트링으로 넘어온다.
        System.out.println("나이 : " + age);

        String gender = req.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = req.getParameter("national");
        System.out.println("국적 : " + national);

        System.out.println("취미 : ");
        String[] hobbies = req.getParameterValues("hobbies"); //배열로 값을 받을 때는 getParameterValues() 메서드를 사용한다.

        for (String hobby : hobbies) {  //쿼리 파라미터 값은 전부 스트링으로 넘어오기 때문에 for문을 통해 배열 값을 보여준다.
            System.out.println(hobby);
        }
    }

}