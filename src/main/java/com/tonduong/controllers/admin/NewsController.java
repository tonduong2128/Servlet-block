package com.tonduong.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonduong.model.NewsModel;
import com.tonduong.service.INewsService;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	INewsService iNewsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/news/list.jsp");

		Integer page = 1;
		Integer limit = 5;
		try {
			page = Integer.parseInt(req.getParameter("count"));
		} catch (Exception e) {
			
		}
		try {
			limit = Integer.parseInt(req.getParameter("limit"));
		} catch (Exception e) {
		}
		List<NewsModel> news = iNewsService.findPage(page, limit);
		req.setAttribute("count", iNewsService.findAll().size());
		req.setAttribute("page", page);
		req.setAttribute("limit", limit);
		req.setAttribute("newsList", news);

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
