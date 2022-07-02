package com.tonduong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tonduong.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(rs.getInt("id"));
			categoryModel.setName(rs.getString("name"));
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setCreateddate(rs.getTimestamp("createddate"));
			categoryModel.setModifieddate(rs.getTimestamp("modifieddate"));
			categoryModel.setId(rs.getInt("createdby"));
			categoryModel.setId(rs.getInt("modifiedby"));
			return categoryModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
