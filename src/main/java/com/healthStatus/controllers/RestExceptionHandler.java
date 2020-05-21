package com.healthStatus.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.healthStatus.dtos.ErrorResponseDto;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleBusinessException(final EntityNotFoundException e) {

		final ErrorResponseDto error = new ErrorResponseDto.Builder().withMessage("Registro não encontrado").build();

		return ResponseEntity//
				.status(406)//
				.header("Content-Type", "application/json; charset=utf-8")//
				.contentType(MediaType.APPLICATION_JSON)//
				.body(error);
	}

}
