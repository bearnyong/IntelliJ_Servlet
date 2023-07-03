package com.study.mvc.common.filter;

import com.study.mvc.common.config.ConfigLocation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    public ContextConfigFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*데이터 접속 설정 정보 파일의 경로가 비어있는 경우 초기화*/
        /*모든 요청들에 대해서 데이터베이스 커넥션 맺기*/
        if (ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
            String root = request.getServletContext().getRealPath("/");
            String conectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            System.out.println("DB 접속 경로 설정 완료 : " + conectionInfoPath);

            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/"+ conectionInfoPath;
        }

        if (ConfigLocation.MAPPER_LOCATION == null) {
            String root = request.getServletContext().getRealPath("/");
            String mapperLocation = request.getServletContext().getInitParameter("mapper-location");
            System.out.println("매퍼 경로 설정 완료 : " + mapperLocation);
            ConfigLocation.MAPPER_LOCATION = root + "/"+mapperLocation;
        }

        /*처음 요청 한건지 아닌지 검사, 처음이 아닐 경우 다음으로 연결해줌..*/
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
