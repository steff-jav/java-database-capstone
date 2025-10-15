package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "username cannot be null")
	@Size(min=3,max=10)
	private String username;
	
	@NotNull(message = "password cannot be null")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
