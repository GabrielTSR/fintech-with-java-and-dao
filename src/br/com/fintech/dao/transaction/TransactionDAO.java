package br.com.fintech.dao.transaction;

import java.util.List;

import br.com.fintech.model.Transaction;

public interface TransactionDAO {
	public void insert(Transaction transaction);
	
	public List<Transaction> getAll();
}