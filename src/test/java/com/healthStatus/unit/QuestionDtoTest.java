package com.healthStatus.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;
import com.healthStatus.entities.Question;
import com.healthStatus.entities.enums.QuestionType;
import com.healthStatus.factory.ModelMapperFactory;

public class QuestionDtoTest {

	@Test
	@DisplayName("Conversão de Question para QuestionResponseDto")
	void questionToDto() throws Exception {
		ModelMapper mapper = new ModelMapperFactory().getModelMapper();

		Question question = new Question();
		question.setId(1l);
		question.setTitle("Test");
		question.setType(QuestionType.TEXT);

		QuestionResponseDto dto = mapper.map(question, QuestionResponseDto.class);

		assertEquals(question.getId(), dto.getId());
		assertEquals(question.getTitle(), dto.getTitle());
		assertEquals(question.getType(), dto.getType());

	}

	@Test
	@DisplayName("Conversão de QuestionRequestDto para Question")
	void dtoToQuestion() throws Exception {
		ModelMapper mapper = new ModelMapperFactory().getModelMapper();

		QuestionRequestDto dto = new QuestionRequestDto();
		dto.setTitle("Test");
		dto.setType(QuestionType.TEXT);

		Question question = mapper.map(dto, Question.class);

		assertEquals(dto.getTitle(), question.getTitle());
		assertEquals(dto.getType(), question.getType());

	}

}
