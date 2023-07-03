package com.study.section02;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncyptFilter implements Filter {

    public PasswordEncyptFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreqeust = (HttpServletRequest) request;
        ServletRequestWrapper wrapper = new ServletRequestWrapper(hreqeust);

        chain.doFilter(wrapper, response);
    }
}
