package com.lifeng.util;

import javax.servlet.*;
import java.io.IOException;

public class SetEncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter拦截器调用");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html,charset='utf-8'");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
