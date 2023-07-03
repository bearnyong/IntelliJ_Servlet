package com.study.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebFilter("/first/*") //필터 이후의 모든 것들은 얘를 거쳐간다.
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("firstFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filrst init 호출");
    }

    @Override
    public void destroy() {
        System.out.println("Filter 소멸");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 호출");
        //필터가 처리할 코드를 작성한다.

        //처리한 뒤 다음 필터 혹은 서블릿 메서드(get,post)를 호출한다.
        chain.doFilter(request, response);

        //서블릿에서 처리한 후에 다시 수행할 내용이 있으면 작성
        System.out.println("fliter 로직 수행 완료");
    }
}
