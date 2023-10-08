package br.com.fintech.factory;

import br.com.fintech.dao.transaction.OracleTransactionDao;
import br.com.fintech.dao.transaction.TransactionDAO;
import br.com.fintech.dao.transactionCategory.OracleTransactionCategoryDao;
import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;

public abstract class DAOFactory {
	public static TransactionCategoryDAO getTransactionCategoryDAO() {
		return new OracleTransactionCategoryDao();
	}
	
	public static TransactionDAO getTransactionDAO() {
		return new OracleTransactionDao();
	}
}