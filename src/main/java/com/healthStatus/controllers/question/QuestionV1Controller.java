package com.healthStatus.controllers.question;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;
import com.healthStatus.services.QuestionService;

@RestController
@RequestMapping(path = "/v1/question")
public class QuestionV1Controller implements QuestionController
{

	@Autowired
	private QuestionService service;

	@Override
	@PostMapping
	public ResponseEntity<QuestionResponseDto> persist(@Valid @RequestBody QuestionRequestDto question)
	{
		return ResponseEntity.ok(service.persist(question));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<QuestionResponseDto>> list()
	{
		return ResponseEntity.ok(service.list());
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<QuestionResponseDto> update(@Valid @PathVariable("id") Long id, @RequestBody QuestionRequestDto question)
	{
		return ResponseEntity.ok(service.update(id, question));
	}

}
