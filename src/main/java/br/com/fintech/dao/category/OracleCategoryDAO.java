package br.com.fintech.dao.category;


import br.com.fintech.jdbc.FintechDBManager;
import br.com.fintech.model.Category;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.ResultSet;

public class OracleCategoryDAO implements CategoryDAO {

	private Connection connection;
	
	@Override
	public void insert(Category category) {
		PreparedStatement stmt = null;

		try {
			this.connection = FintechDBManager.getConnection();
			String sql = "INSERT INTO TBL_CATEGORY (ID, NAME, DESCRIPTION) VALUES (SQ_CATEGORY.nextval, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, transactionCategory.getName());
			stmt.setString(2, transactionCategory.getDescription());

			stmt.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Category> listar() {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List<Category> categorys = new ArrayList<>();

		try {
			this.connection = FintechDBManager.getConnection();
			String query = "SELECT ID, DESCRIPTION, NAME FROM TBL_CATEGORY";
			stmt = connection.prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String description = resultSet.getString("DESCRIPTION");
				String name = resultSet.getString("NAME");
				Category category = new Category(description, name, id);
				categorys.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categorys;
	}

}
