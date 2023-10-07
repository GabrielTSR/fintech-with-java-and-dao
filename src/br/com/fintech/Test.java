package br.com.fintech;

import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.model.TransactionCategory;

public class Test {

	public static void main(String[] args) {
		try {
			TransactionCategoryDAO transactionCategoryDao = DAOFactory.getTransactionCategoryDAO();
			TransactionCategory jobCategory = new TransactionCategory("Trabalho");
			transactionCategoryDao.create(jobCategory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
