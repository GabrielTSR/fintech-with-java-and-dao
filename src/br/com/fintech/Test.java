package br.com.fintech;

import java.util.List;

import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.model.TransactionCategory;

public class Test {
	public static void main(String[] args) {
		try {
			TransactionCategoryDAO transactionCategoryDao = DAOFactory.getTransactionCategoryDAO();
			
			TransactionCategory jobCategory = new TransactionCategory("Dinheiro recebido através da mão de obra", "Trabalho");
			transactionCategoryDao.insert(jobCategory);
			
			TransactionCategory shoppingCategory = new TransactionCategory("Produtos adquiridos por necessidades básicas", "Compras");
			transactionCategoryDao.insert(shoppingCategory);
			
			TransactionCategory gamesCategory = new TransactionCategory("Gastos com entretenimento relacionado a jogos", "Jogos");
			transactionCategoryDao.insert(gamesCategory);
			
			TransactionCategory sportCategory = new TransactionCategory("Equipamentos necessários para a prática de esportes", "Esporte");
			transactionCategoryDao.insert(sportCategory);
			
			TransactionCategory coursesCategory = new TransactionCategory("Mensalidade de conteúdos estudados", "Cursos");
			transactionCategoryDao.insert(coursesCategory);
			
			List<TransactionCategory> transactionCategories = transactionCategoryDao.getAll();
			
			for (TransactionCategory transactionCategory : transactionCategories) {
				System.out.println(transactionCategory.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
