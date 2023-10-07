package br.com.fintech.model;

import java.time.LocalDateTime;

public class TransactionCategory {
	private LocalDateTime createdAt;
	private String description;

	public TransactionCategory(String description) {
		super();
		this.createdAt = LocalDateTime.now();
		this.description = description;
		System.out.printf("Categoria %s foi criada! %n", description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
