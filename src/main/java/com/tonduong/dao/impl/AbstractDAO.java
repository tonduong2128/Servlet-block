package com.tonduong.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import com.tonduong.dao.GenericDAO;
import com.tonduong.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("db");
			Class.forName(bundle.getString("DRIVER_NAME")); // Load driver
			String URL = bundle.getString("URL");
			Properties info = new Properties();
			info.put("user", bundle.getString("USER"));
			info.put("password", bundle.getString("PASSWORD"));
			Connection con = DriverManager.getConnection(URL, info);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> List<T> query(String query, RowMapper<T> rowMapper, Object... paramaters) {
		List<T> results = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);

			// set paramater
			setParameter(preparedStatement, paramaters);

			resultSet = preparedStatement.executeQuery();
			connection.commit();

			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			preparedStatement.close();
			connection.close();
			return results;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return null;
		}
	}

	public <T> Integer insert(String query, RowMapper<T> rowMapper, Object... paramaters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Integer id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			// set paramater
			setParameter(preparedStatement, paramaters);

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			connection.commit();

			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}

			preparedStatement.close();
			connection.close();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> Integer update(String query, RowMapper<T> rowMapper, Object... paramaters) {
		Integer count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);

			// set paramater
			setParameter(preparedStatement, paramaters);

			count = preparedStatement.executeUpdate();
			connection.commit();

			preparedStatement.close();
			connection.close();
			return count;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return count;
		}
	}

	@Override
	public <T> Integer delete(String query, RowMapper<T> rowMapper, Object... paramaters) {
		Integer count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);

			// set paramater
			setParameter(preparedStatement, paramaters);

			count = preparedStatement.executeUpdate();
			connection.commit();

			preparedStatement.close();
			connection.close();
			return count;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return count;
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				if (parameter instanceof Integer) {
					statement.setInt(i + 1, (Integer) parameter);
				} else if (parameter instanceof String) {
					statement.setString(i + 1, (String) parameter);
					;
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) parameter);
				} else {
					statement.setObject(i + 1, parameter);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
