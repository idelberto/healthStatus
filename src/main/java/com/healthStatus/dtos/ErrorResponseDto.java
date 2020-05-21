package com.healthStatus.dtos;

public class ErrorResponseDto {

	private ErrorResponseDto() {
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public static class Builder {

		private String message;

		public Builder withMessage(final String message) {
			this.message = message;
			return this;
		}

		public ErrorResponseDto build() {
			final ErrorResponseDto dto = new ErrorResponseDto();

			dto.message = message;

			return dto;
		}

	}
}
