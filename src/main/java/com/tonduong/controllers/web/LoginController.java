package com.tonduong.controllers.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/dang-nhap" })
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Boolean out = req.getParameter("out") != null && req.getParameter("out").equals("true");
		if (out) {
			req.getSession().removeAttribute("role");
			resp.sendRedirect("./dang-nhap");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("username").equals("admin") && req.getParameter("password").equals("admin")) {
			session.setAttribute("role", "admin");
			resp.sendRedirect("./admin");
		} else if (req.getParameter("username").equals("user") && req.getParameter("password").equals("user")) {
			session.setAttribute("role", "user");
			resp.sendRedirect("./trang-chu");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
			req.setAttribute("message", "Dăng nhập không thành công!!!");
			dispatcher.forward(req, resp);
		}
	}
}
