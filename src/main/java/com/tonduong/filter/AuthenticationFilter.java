package com.tonduong.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/admin/*" })
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("start");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println(req.getRequestURI());
		HttpSession session = req.getSession();
		if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")
				&& req.getServletPath().contains("/admin")) {
			chain.doFilter(request, response);
		} else if (session.getAttribute("role") != null && session.getAttribute("role").equals("user")
				&& !req.getServletPath().contains("/admin")) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("./dang-nhap");
		}
	}

	@Override
	public void destroy() {
		System.out.println("end");
	}
}
