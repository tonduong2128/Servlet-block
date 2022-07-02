package com.tonduong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tonduong.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setId(rs.getInt("id"));
			newsModel.setTitle(rs.getString("title"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setShortdescription(rs.getString("shortdescription"));
			newsModel.setCategoryid(rs.getInt("categoryid"));
			newsModel.setCreateddate(rs.getTimestamp("createddate"));
			newsModel.setModifieddate(rs.getTimestamp("modifieddate"));
			newsModel.setCreatedby(rs.getInt("createdby"));
			newsModel.setModifiedby(rs.getInt("modifiedby"));
			return newsModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
