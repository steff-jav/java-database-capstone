package com.project.back_end.models;

import java.util.List;
import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.persistence.ElementCollection;

@Entity 
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message=" Doctor's name cannot be null")
	@Size(min=3,max=100)
	private String name;
	
	@NotNull(message=" specialty cannot be null")
	@Size(min=3,max=50)
	private String specialty;
	
	@NotNull(message=" email cannot be empty")
	@Email
	private String email;
	
	@NotNull(message=" password cannot be empty")
	@Size(min=6)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotNull(message=" phone cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String phone;
	
	@ElementCollection
	private List<String> availableTimes;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public List<String> getAvailableTimes() {
		return availableTimes;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAvailableTimes(List<String> availableTimes) {
		this.availableTimes = availableTimes;
	}
}

