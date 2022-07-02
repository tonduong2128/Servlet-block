package com.tonduong.dao.impl;

import java.util.List;

import com.tonduong.dao.ICategoryDAO;
import com.tonduong.mapper.CategoryMapper;
import com.tonduong.model.CategoryModel;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {
//	@Override
//	public List<CategoryModel> findAll() {
//		List<CategoryModel> results = new ArrayList<CategoryModel>();
//		String query = "Select * from category";
//		Connection con = getConnection();
//		if (null != con) {
//			try {
//				PreparedStatement stm = con.prepareStatement(query);
//				ResultSet rs = stm.executeQuery();
//				while (rs.next()) {
//					CategoryModel categoryModel = new CategoryModel();
//					categoryModel.setId(rs.getInt("id"));
//					categoryModel.setName(rs.getString("name"));
//					categoryModel.setCode(rs.getString("code"));
//					categoryModel.setCreateddate(rs.getTimestamp("createddate"));
//					categoryModel.setModifieddate(rs.getTimestamp("modifieddate"));
//					categoryModel.setId(rs.getInt("createdby"));
//					categoryModel.setId(rs.getInt("modifiedby"));
//					results.add(categoryModel);
//				}
//
//				stm.close();
//				con.close();
//				return results;
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
//		return null;
//	}
	@Override
	public List<CategoryModel> findAll() {
		String query = "Select * from category";
		return query(query, new CategoryMapper());
	}

//	@Override
//	public CategoryModel findWithCode(String code) {
//		CategoryModel result = new CategoryModel();
//		String query = "Select * from category where code=?";
//		Connection con = getConnection();
//		if (null != con) {
//			try {
//				PreparedStatement stm = con.prepareStatement(query);
//				stm.setString(1, code);
//				ResultSet rs = stm.executeQuery();
//				if (rs.next()) {
//					result.setId(rs.getInt("id"));
//					result.setName(rs.getString("name"));
//					result.setCode(rs.getString("code"));
//					result.setCreateddate(rs.getTimestamp("createddate"));
//					result.setModifieddate(rs.getTimestamp("modifieddate"));
//					result.setId(rs.getInt("createdby"));
//					result.setId(rs.getInt("modifiedby"));
//				} else {
//					stm.close();
//					con.close();
//					return null;
//				}
//				stm.close();
//				con.close();
//				return result;
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
//		return null;
//	}
	@Override
	public List<CategoryModel> findWithCode(String code) {
		String query = "Select * from category where code=?";
		return query(query, new CategoryMapper(),code);
	}
}
