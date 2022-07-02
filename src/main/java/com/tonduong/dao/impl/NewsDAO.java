package com.tonduong.dao.impl;

import java.util.List;

import com.tonduong.dao.INewsDAO;
import com.tonduong.mapper.NewsMapper;
import com.tonduong.model.NewsModel;

public class NewsDAO extends AbstractDAO implements INewsDAO {

//	@Override
//	public NewsModel findByID(Integer id) {
//		NewsModel result = new NewsModel();
//		String query = "Select * from category where id=?";
//		Connection con = getConnection();
//		if (null != con) {
//			try {
//				PreparedStatement stm = con.prepareStatement(query);
//				stm.setInt(1, id);
//				ResultSet rs = stm.executeQuery();
//				if (rs.next()) {
//					result.setId(rs.getInt("id"));
//					result.setContent(rs.getString("content"));
//					result.setThumbnail(rs.getString("thumbnail"));
//					
//						result.setCreateddate(rs.getTimestamp("createddate"));
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
	public NewsModel findByID(Integer id) {
		String query = "Select * from news where id=?";
		// TODO Auto-generated method stub
		List<NewsModel> listNews = query(query, new NewsMapper(), id);
		return listNews.isEmpty() ? null : listNews.get(0);
	}

	@Override
	public Integer save(NewsModel newsModel) {
		Integer id = null;
		String query = "Insert into news (title, content, thumbnail, shortdescription, categoryid,"
				+ " modifieddate, createdby, modifiedby ) values(?, ?, ?, ?, ?, ?, ?, ?)";
		id = insert(query, new NewsMapper(),newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortdescription(), newsModel.getCategoryid(), newsModel.getModifieddate(),
				newsModel.getCreatedby(), newsModel.getModifiedby());
		return id;
	}

	@Override
	public Integer update(NewsModel newsModel) {
		Integer count = 0;
		String query = "Update news set title=?, content=?,  thumbnail=?, shortdescription=?, categoryid=?, "
				+ " createddate=?, modifieddate=?, createdby=?, modifiedby=? where id=?";
		count = update(query, new NewsMapper(),newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortdescription(), newsModel.getCategoryid(), newsModel.getCreateddate(),
				newsModel.getModifieddate(), newsModel.getCreatedby(), newsModel.getModifiedby(), newsModel.getId());
		return count;
	}

	@Override
	public Integer delete(Integer id) {
		Integer count = 0;
		String query = "Delete from news where id=?";
		count = delete(query, new NewsMapper(), id);
		return count;
	}

	@Override
	public List<NewsModel> findAll() {
		String query = "Select * from news order by createddate";
		List<NewsModel> newsModels = query(query, new NewsMapper());
		return newsModels;
	}

	@Override
	public List<NewsModel> findPage(Integer count, Integer limit) {
		String query = "Select * from news order by createddate limit ?,?";
		List<NewsModel> newsModels = query(query, new NewsMapper(),(count-1)*limit, limit);
		return newsModels;
	}
}
