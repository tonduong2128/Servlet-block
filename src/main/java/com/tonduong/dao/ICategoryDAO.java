package com.tonduong.dao;

import java.util.List;

import com.tonduong.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO {
	public List<CategoryModel> findAll();
	public List<CategoryModel> findWithCode(String code);
}
