package com.tonduong.dao;

import java.util.List;

import com.tonduong.model.NewsModel;

public interface INewsDAO extends GenericDAO{
	public NewsModel findByID(Integer id);
	public List<NewsModel> findAll();
	public List<NewsModel> findPage(Integer count,Integer limit);
	public Integer save(NewsModel newsModel);
	public Integer update(NewsModel newsModel);
	public Integer delete(Integer id);
}
