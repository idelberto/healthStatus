package com.healthStatus.dtos.user;

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

}
