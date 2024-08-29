package com.coding.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

	@NotBlank(message="Email is required")
	private String email;
	@NotBlank(message="password is required")
	private String password;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequest(@NotBlank(message = "Email is required") String email,
			@NotBlank(message = "password is required") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public LoginRequest() {
		super();
	}
	
	
}
