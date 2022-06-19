package com.tonduong.controllers.admin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonduong.model.NewsModel;
import com.tonduong.service.INewsService;
import com.tonduong.util.HttpUtil;
import com.tonduong.util.Json;

@WebServlet(urlPatterns = { "/api-admin/news" })
public class NewsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService iNewsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		Integer id = null;
		Integer page = null;
		Integer limit = null;

		String data1 = "";
		BufferedReader reader = req.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				data1 += line;
			}
		} catch (Exception e) {
		}
		System.out.println(data1);
		System.out.println(1);
		
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
		}
		try {
			page = Integer.parseInt(req.getParameter("count"));
		} catch (Exception e) {

		}
		try {
			limit = Integer.parseInt(req.getParameter("limit"));
		} catch (Exception e) {
		}
		List<NewsModel> newsModels = null;
		if (id != null) {
			NewsModel newsModel = iNewsService.findById(id);
			if (newsModel != null) {
				String data = new ObjectMapper().writeValueAsString(newsModel);
				printWriter.write(data);
			} else {
				printWriter.write("Not found");
			}
		} else if (page != null && limit != null) {
			newsModels = iNewsService.findPage(page, limit);
		} else {
			newsModels = iNewsService.findAll();
		}
		printWriter.write(new ObjectMapper().writeValueAsString(newsModels));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		HttpUtil data = HttpUtil.of(req.getReader());
		NewsModel newsModel = data.toModel(NewsModel.class);

		Integer idNews = iNewsService.save(newsModel);

		PrintWriter printWriter = resp.getWriter();

		printWriter.print(Json.stringify(iNewsService.findById(idNews)));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpUtil data = HttpUtil.of(req.getReader());
		NewsModel newsModel = data.toModel(NewsModel.class);

		Integer count = iNewsService.update(newsModel);

		PrintWriter printWriter = resp.getWriter();
		printWriter.print(Json.stringify(count));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idNews = null;
		Integer count = 0;
		PrintWriter printWriter = resp.getWriter();
		try {
			idNews = Integer.parseInt(req.getParameter("id"));
			count = iNewsService.detete(idNews);
			printWriter.print(Json.stringify(count));
		} catch (Exception e) {
			printWriter.write("Can't read id news");
		}
	}

}
