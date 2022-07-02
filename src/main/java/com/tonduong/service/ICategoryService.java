package com.tonduong.service;

import java.util.List;

import com.tonduong.model.CategoryModel;

public interface ICategoryService {
	public List<CategoryModel> findAll();
	public List<CategoryModel> findWithCode(String code);
}
