package br.com.fintech.model;

import java.util.ArrayList;
import java.util.List;

public class FinancialAccount extends User {
	private List<Transaction> transactions;

	public FinancialAccount(String name, String email, String hashedPassword) {
		super(name, email, hashedPassword);
		this.transactions = new ArrayList<Transaction>();
		System.out.printf("%s foi cadastrado, seu saldo atual é de R$%f %n", this.getName(), this.getBalance());
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void performTransaction(double value, TransactionCategory transactionCategory) throws Exception {
		Transaction transaction = new Transaction(value, transactionCategory);
		this.transactions.add(transaction);
		System.out.printf("%s acaba de fazer uma transação de R$%f, seu saldo atual é de R$%f %n", this.getName(),
				value, this.getBalance());
	}

	public double getBalance() {
		double balance = 0.0;
		for (Transaction transaction : transactions) {
			balance += transaction.getValue();
		}
		return balance;
	}

	public double getInputValues() {
		double inputSum = 0.0;
		for (Transaction transaction : transactions) {
			if (transaction.getValue() > 0) {
				inputSum += transaction.getValue();
			}
		}
		System.out.printf("No total %s recebeu R$%f %n", this.getName(), inputSum);
		return inputSum;
	}

	public double getOutputValues() {
		double outputSum = 0.0;
		for (Transaction transaction : transactions) {
			if (transaction.getValue() < 0) {
				outputSum += transaction.getValue();
			}
		}
		System.out.printf("No total %s gastou R$%f %n", this.getName(), outputSum);
		return outputSum;
	}
}
