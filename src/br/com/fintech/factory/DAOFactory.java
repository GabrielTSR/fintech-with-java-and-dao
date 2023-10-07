package br.com.fintech.factory;

import br.com.fintech.dao.transactionCategory.OracleTransactionCategoryDao;
import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;

public abstract class DAOFactory {
	public static TransactionCategoryDAO getTransactionCategoryDAO() {
		return new OracleTransactionCategoryDao();
	}
}