package com.healthStatus.controllers.question;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;

public interface QuestionController
{

	public ResponseEntity<QuestionResponseDto> persist(QuestionRequestDto question);

	public ResponseEntity<List<QuestionResponseDto>> list();

	public ResponseEntity<QuestionResponseDto> update(Long id, QuestionRequestDto question);
}
