package com.healthStatus.dtos.user;

import java.util.Base64;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
	
	@NotNull
	@NotEmpty
	private String			name;
	
	@NotNull
	private String			userName;

	@NotNull
	private String			password;
	
	public void setPassword(String password)
	{
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
	}

}
