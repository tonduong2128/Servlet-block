package com.tonduong.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.tonduong.dao.INewsDAO;
import com.tonduong.model.NewsModel;
import com.tonduong.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO iNewsDAO;

	@Override
	public Integer save(NewsModel newsModel) {
		Integer id = iNewsDAO.save(newsModel);
		return id;
	}

	@Override
	public NewsModel findById(Integer id) {
		return iNewsDAO.findByID(id);
	}

	@Override
	public Integer update(NewsModel newsModel) {
		Integer count = iNewsDAO.update(newsModel);
		return count;
	}

	@Override
	public Integer update(List<NewsModel> newsModels) {
		Integer count = 0;
		for (NewsModel newsModel : newsModels) {
			count += iNewsDAO.update(newsModel);
		}
		return count;
	}

	@Override
	public Integer detete(Integer id) {
		Integer count = iNewsDAO.delete(id);
		return count;
	}

	@Override
	public List<NewsModel> findAll() {
		List<NewsModel> newsModels = iNewsDAO.findAll();
		return newsModels;
	}

	@Override
	public List<NewsModel> findPage(Integer count, Integer limit) {
		List<NewsModel> newsModels = iNewsDAO.findPage(count, limit);
		return newsModels;
	}
}
