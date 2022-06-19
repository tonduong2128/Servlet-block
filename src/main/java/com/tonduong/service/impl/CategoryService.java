package com.tonduong.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.tonduong.dao.ICategoryDAO;
import com.tonduong.model.CategoryModel;
import com.tonduong.service.ICategoryService;

public class CategoryService implements ICategoryService {

// Servlet weld: Cách 1	
//	private ICategoryDAO categoryDAO;
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}

	// Servlet weld: Cách 2
	@Inject
	private ICategoryDAO categoryDAO;

	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public List<CategoryModel> findWithCode(String code) {
		return categoryDAO.findWithCode(code);
	}
}
