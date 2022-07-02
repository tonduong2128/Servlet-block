package com.tonduong.controllers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonduong.model.NewsModel;
import com.tonduong.service.ICategoryService;
import com.tonduong.service.INewsService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class Homecontroller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private ICategoryService categoryService;
	
	@Inject
	private INewsService newsService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel newsModel = new NewsModel();
		newsModel.setContent("Bài viết 4");
		
		newsModel.setThumbnail("...");
		newsModel.setShortdescription("description");
		newsModel.setCategoryid(1);
		
		newsService.save(newsModel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		req.setAttribute("categorys", categoryService.findAll());
		req.setAttribute("category", categoryService.findWithCode("the-thao"));
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
