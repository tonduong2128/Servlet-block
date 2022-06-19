package com.tonduong.dao;

import java.util.List;

import com.tonduong.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String query, RowMapper<T> rowMapper, Object...paramaters);
	<T> Integer insert(String query, RowMapper<T> rowMapper, Object...paramaters);
	<T> Integer update(String query, RowMapper<T> rowMapper, Object...paramaters);
	<T> Integer delete(String query, RowMapper<T> rowMapper, Object...paramaters);
}
