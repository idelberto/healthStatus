package com.healthStatus.dtos;

import java.util.Optional;

import org.springframework.validation.ObjectError;

public class ErrorResponseDto
{

	private ErrorResponseDto()
	{
	}

	private String message;

	public String getMessage()
	{
		return message;
	}

	public static class Builder
	{

		private String			message;

		private ObjectError	objectError;

		public Builder withMessage(final String message)
		{
			this.message = message;
			return this;
		}

		public Builder withObjectError(ObjectError objectError)
		{
			this.objectError = objectError;
			return this;
		}

		public ErrorResponseDto build()
		{
			final ErrorResponseDto dto = new ErrorResponseDto();

			if(Optional.ofNullable(objectError).isPresent())
			{
				String fieldName = objectError.getObjectName();
				String errorMessage = objectError.getDefaultMessage();

				dto.message = String.format("%s: %s", fieldName, errorMessage);
			}
			else
			{
				dto.message = message;
			}

			return dto;
		}

	}
}
