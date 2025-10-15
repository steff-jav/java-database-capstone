package com.project.back_end.models;


import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="name field cannot be empty" )
	@Size(min=3,max=100)
	private String name;
	
	@NotNull(message=" email cannot be empty")
	@Email
	private String email;
	
	@NotNull(message=" password cannot be empty")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotNull(message=" phone cannot be empty")
	@Pattern(regexp="^[0-9]{10}$",message="phone number must be 10 digits")
	private String phone;
	
	@NotNull(message=" address cannot be empty")
	@Size(max=255)
	private String address;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
  

}
