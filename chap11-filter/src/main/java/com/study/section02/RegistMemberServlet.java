package com.study.section02;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String pass = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId : " + userId);
        System.out.println("pass : " + pass);
        System.out.println("name : " + name);

        //BCryptPasswordEncoder : 복호화가 되지 않도록 함
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호 확인 pass01 : " + passwordEncoder.matches("pass01", pass));
        System.out.println("비밀번호 확인 pass02 : " + passwordEncoder.matches("pass02", pass));
    }
}
