package br.com.fintech.model;

import java.time.LocalDateTime;

public class Transaction {
	private double value;
	private LocalDateTime createdAt;
	private TransactionCategory transactionCategory;

	public Transaction(double value, TransactionCategory transactionCategory) throws Exception {
		if (value == 0) {
			throw new Exception("A transação deve ser um número diferente de 0");
		}
		this.value = value;
		this.createdAt = LocalDateTime.now();
		this.transactionCategory = transactionCategory;
	}

	public double getValue() {
		return value;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public TransactionCategory getTransactionCategory() {
		return transactionCategory;
	}

}
