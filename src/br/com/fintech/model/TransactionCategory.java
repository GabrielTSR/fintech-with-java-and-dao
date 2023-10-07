package br.com.fintech.model;

import java.time.LocalDateTime;

public class TransactionCategory {
	private LocalDateTime createdAt;
	private String description;
	private int id;
	
	public TransactionCategory(String description, LocalDateTime createdAt, int id) {
		super();
		this.createdAt = createdAt;
		this.description = description;
		this.id = id;
		System.out.printf("Categoria %s foi criada! %n", description);
	}

	public String getDescription() {
		return this.description;
	}

	public int id() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
