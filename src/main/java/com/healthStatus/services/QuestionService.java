package com.healthStatus.services;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;
import com.healthStatus.entities.Question;
import com.healthStatus.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public QuestionResponseDto persist(QuestionRequestDto requestDto) {

		Question question = modelMapper.map(requestDto, Question.class);
		question = repository.save(question);
		return modelMapper.map(question, QuestionResponseDto.class);
	}

	public List<QuestionResponseDto> list() {
		Type listType = new TypeToken<List<QuestionResponseDto>>() {
		}.getType();

		return modelMapper.map(repository.findAll(), listType);
	}

	public QuestionResponseDto update(Long id, QuestionRequestDto requestDto) {

		repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

		Question question = modelMapper.map(requestDto, Question.class);
		question.setId(id);
		question = repository.save(question);
		return modelMapper.map(question, QuestionResponseDto.class);

	}

}
