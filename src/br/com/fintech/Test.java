package br.com.fintech;

import java.util.List;

import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.model.TransactionCategory;

public class Test {

	public static void main(String[] args) {
		try {
			TransactionCategoryDAO transactionCategoryDao = DAOFactory.getTransactionCategoryDAO();
			TransactionCategory jobCategory = new TransactionCategory("Trabalho");
			transactionCategoryDao.insert(jobCategory);
			
			TransactionCategory shoppingCategory = new TransactionCategory("Compras");
			transactionCategoryDao.insert(shoppingCategory);
			
			TransactionCategory gamesCategory = new TransactionCategory("Jogos");
			transactionCategoryDao.insert(gamesCategory);
			
			TransactionCategory sportCategory = new TransactionCategory("Esporte");
			transactionCategoryDao.insert(sportCategory);
			
			TransactionCategory coursesCategory = new TransactionCategory("Cursos");
			transactionCategoryDao.insert(coursesCategory);
			
			List<TransactionCategory> transactoinCategories = transactionCategoryDao.getAll();
			System.out.println(transactoinCategories);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
