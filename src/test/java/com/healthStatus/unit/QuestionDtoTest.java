package com.healthStatus.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.healthStatus.dtos.QuestionDto;
import com.healthStatus.entities.Question;
import com.healthStatus.entities.enums.QuestionType;
import com.healthStatus.factory.ModelMapperFactory;

public class QuestionDtoTest {

	@Test
	@DisplayName("Conversão de Question para QuestionDto")
	void questionToDto() throws Exception {
		ModelMapper mapper = new ModelMapperFactory().getModelMapper();

		Question question = new Question();
		question.setId(1l);
		question.setTitle("Test");
		question.setType(QuestionType.TEXT);

		QuestionDto dto = mapper.map(question, QuestionDto.class);

		assertEquals(question.getId(), dto.getId());
		assertEquals(question.getTitle(), dto.getTitle());
		assertEquals(question.getType(), dto.getType());

	}

	@Test
	@DisplayName("Conversão de QuestionDto para Question")
	void dtoToQuestion() throws Exception {
		ModelMapper mapper = new ModelMapperFactory().getModelMapper();

		QuestionDto dto = new QuestionDto();
		dto.setId(1l);
		dto.setTitle("Test");
		dto.setType(QuestionType.TEXT);

		Question question = mapper.map(dto, Question.class);

		assertEquals(dto.getId(), question.getId());
		assertEquals(dto.getTitle(), question.getTitle());
		assertEquals(dto.getType(), question.getType());

	}

}
