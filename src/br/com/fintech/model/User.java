package br.com.fintech.model;

import java.time.LocalDateTime;

public class User {
	private String name;
	private String email;
	private String hashedPassword;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.hashedPassword = this.hashPassword(password);
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public String hashPassword(String password) {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.updatedAt = LocalDateTime.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		this.updatedAt = LocalDateTime.now();
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
		this.updatedAt = LocalDateTime.now();
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
