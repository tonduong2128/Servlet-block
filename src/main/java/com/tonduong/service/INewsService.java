package com.tonduong.service;

import java.util.List;

import com.tonduong.model.NewsModel;

public interface INewsService {
	public Integer save(NewsModel newsModel);

	public Integer update(NewsModel newsModel);
	public Integer update(List<NewsModel> newsModel);
	
	public Integer detete(Integer id);
	
	public NewsModel findById(Integer id);
	
	public List<NewsModel> findAll();
	public List<NewsModel> findPage(Integer count, Integer limit);
}
