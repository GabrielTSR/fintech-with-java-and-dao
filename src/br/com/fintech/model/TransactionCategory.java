package br.com.fintech.model;

import java.time.LocalDateTime;

public class TransactionCategory {
	private LocalDateTime createdAt;
	private String description;
	private int id;
	
	public TransactionCategory(String description) {
		super();
		this.createdAt = LocalDateTime.now();
		this.description = description;
		System.out.printf("Categoria %s foi criada! %n", description);
	}
	
	public TransactionCategory(String description, LocalDateTime createdAt, int id ) {
		super();
		this.createdAt = createdAt;
		this.id = id;
		this.description = description;
		System.out.printf("Categoria %s foi criada! %n", description);
	}

	public String getDescription() {
		return this.description;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
