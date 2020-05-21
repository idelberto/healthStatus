package com.healthStatus.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.healthStatus.dtos.ErrorResponseDto;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleBusinessException(final EntityNotFoundException e)
	{

		final ErrorResponseDto error = new ErrorResponseDto.Builder().withMessage("Registro não encontrado").build();

		return ResponseEntity//
			.status(HttpStatus.NOT_ACCEPTABLE)//
			.header("Content-Type", "application/json; charset=utf-8")//
			.contentType(MediaType.APPLICATION_JSON)//
			.body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
		WebRequest request)
	{
		List<ErrorResponseDto> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errors.add(new ErrorResponseDto.Builder().withObjectError(error).build());
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}
