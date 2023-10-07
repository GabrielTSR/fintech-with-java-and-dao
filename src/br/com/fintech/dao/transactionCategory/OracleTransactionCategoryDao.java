package br.com.fintech.dao.transactionCategory;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.sql.ResultSet;

import br.com.fintech.jdbc.FintechDBManager;
import br.com.fintech.model.TransactionCategory;
import br.com.fintech.model.User;

public class OracleTransactionCategoryDao implements TransactionCategoryDAO {

	private Connection connection;

	public void create(TransactionCategory transactionCategory) {
		PreparedStatement stmt = null;

		try {
			connection = FintechDBManager.obterConexao();
			String sql = "INSERT INTO TAB_TRANSACTION_CATEGORY(ID, DESCRIPTION, CREATED_AT) VALUES (SQ_TRANSACTION_CATEGORY.NEXTVAL, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, transactionCategory.getDescription());
			Instant instant = transactionCategory.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant();
			java.util.Date utilDate = Date.from(instant);
			java.sql.Date createdAt = new java.sql.Date(utilDate.getTime());
			stmt.setDate(2, createdAt);

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
	
	public List<TransactionCategory> getAll() {
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    ResultSet resultSet = null;
	    List<TransactionCategory> transactionCategories = new ArrayList<>();

	    try {
	        connection = FintechDBManager.obterConexao();
	        String query = "SELECT ID, DESCRIPTION, CREATED_AT FROM TAB_TRANSACTION_CATEGORY";
	        stmt = connection.prepareStatement(query);
	        resultSet = stmt.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("ID");
	            String description = resultSet.getString("DESCRIPTION");
	            LocalDateTime createdAt = resultSet.getTimestamp("CREATED_AT").toLocalDateTime();
	            TransactionCategory category = new TransactionCategory(description, createdAt, id);
	            transactionCategories.add(category);
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
	    return transactionCategories;
	}

}
