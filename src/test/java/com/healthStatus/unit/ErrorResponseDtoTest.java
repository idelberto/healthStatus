package com.healthStatus.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.ObjectError;

import com.healthStatus.dtos.ErrorResponseDto;

public class ErrorResponseDtoTest
{

	@Test
	@DisplayName("Gerando um ErrorResponseDto a partir de um ObjectError")
	void objectError()
	{
		ObjectError objectError = new ObjectError("name", "Invalid name");

		ErrorResponseDto dto = new ErrorResponseDto.Builder().withObjectError(objectError).build();

		assertEquals("name: Invalid name", dto.getMessage());

	}

}
