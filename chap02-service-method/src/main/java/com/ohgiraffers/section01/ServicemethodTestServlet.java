package com.ohgiraffers.section01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/request-service")
public class ServicemethodTestServlet extends HttpServlet {
    public ServicemethodTestServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        /*Request는 요청을 의미하며 이는 요청한 쪽은 method를 확인해야 한다. (ex.선물 주는 사람이 선물 뭐 주는 지 아는 것과 같은 늒임..)*/
        String httpMethod = httpServletRequest.getMethod();
        System.out.println("http method : " + httpMethod);

        /*사용자의 요청을 확인하여 보내주는 역할을 수행함. 왜냐? 더 효율적인 방법이기 때문에...*/
        if(("GET").equals(httpMethod)) {
            /*POST 요청은 주소 값을 보여준다. (ex.http://localhost:8080/request-service)*/
            /*아래의 doGet 메서드와 매개변수의 타입을 일치시킨다.*/
            doGet(httpServletRequest, httpServletResponse);
        } else if (("POST").equals(httpMethod)) {
            /*GET 요청은 주소 값을 숨겨준다. (ex.http://localhost:8080/)*/
            /*아래의 doPost 메서드와 매개변수의 타입을 일치시킨다.*/
            doPost(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* GET 방식의 요청은 QueryStringParameter이라는 방식으로 데이터를 전송하게 된다.
        *  'https://cafe.naver.com/{single2678}?postNum=6756'와 같이 요청을 전달하게 된다.
        *  데이터가 노출되어 중요하지 않은 값 post번호 혹은 일반적인 데이터를 주고 받는다.
        *  주소창의 크기만큼 데이터를 주고 받기 때문에 데이터의 범위가 크지 않아 파일을 주고 받을 때 사용하지 않는다.*/
        System.out.println("GET 요청을 처리할 메서드 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* Post 방식의 요청은 데이터가 body에 담겨져서 전송된다.
        *  'https://cafe.naver.com/{single2678}' 요청되는 url은 다음과 같다
        *  데이터가 노출되지 않아 보안성이 능가하며 http boby에 데이터를 담아 오기 때문에
        *  많은 양의 데이터를 전송하는 것이 가능하다.*/
        System.out.println("POST 요청을 처리할 메서드 호출");
    }
}