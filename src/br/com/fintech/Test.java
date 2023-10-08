package br.com.fintech;

import java.util.List;

import br.com.fintech.dao.transaction.TransactionDAO;
import br.com.fintech.dao.transactionCategory.TransactionCategoryDAO;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.model.Transaction;
import br.com.fintech.model.TransactionCategory;
import br.com.fintech.model.User;

public class Test {
	public static void main(String[] args) {
		try {
			TransactionCategoryDAO transactionCategoryDao = DAOFactory.getTransactionCategoryDAO();
			TransactionDAO transactionDao = DAOFactory.getTransactionDAO();
			
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
			
			User guilherme = new User("Guilherme", "guilherme@fiap.com", "senha123", 1);
			
			Transaction transaction = new Transaction("UX Design", 30.0, "Precisou de dinheiro para compra de curso", guilherme, coursesCategory);
			
			transactionDao.insert(transaction);
			
			List<Transaction> transactions = transactionDao.getAll();
			
			for (Transaction eachTransaction: transactions) {
				System.out.println(eachTransaction.toString());
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
