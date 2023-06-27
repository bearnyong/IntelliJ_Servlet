package com.ohgiraffers.section02.annotation;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
//index.jsp 파일의 <a href="/hello-servlet">annotation</a>이 호출된 것임..
public class annotationLifeCycleTest extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int intCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    /*서블릿에 등록하는 클래스는 기본 생성자를 필수로 등록해야 한다. !!!*/
    public annotationLifeCycleTest() {
    }

    /*아래 순서는 서블릿의 동작 순서별임*/

    /*서블릿의 최초 요청시에 동작하는 메소드이다.*/
    @Override
    public void init() throws ServletException {
        System.out.println("annotation 설정 매핑 init() 메소드 호출 : " + intCount++);
    }

    /*사용자의 두 번째 요청부터는 init() 호출 없이 바로 service()를 호출한다.*/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자의 요청을 확인하여 doGet / doPost로 요청을 전달한다.
        System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    /*서블릿이 소멸될 때 동작되는 메서드로 자원을 반납하는 용도로 사용된다.*/
    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destory() 메소드 호출 : " + destroyCount++);
    }

}
