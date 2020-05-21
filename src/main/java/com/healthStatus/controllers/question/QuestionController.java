package com.healthStatus.controllers.question;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;

public interface QuestionController {

	public ResponseEntity<QuestionResponseDto> persist(@RequestBody QuestionRequestDto question);

	public ResponseEntity<List<QuestionResponseDto>> list();

	public ResponseEntity<QuestionResponseDto> update(@PathVariable("id") Long id,  @RequestBody QuestionRequestDto question);
}
