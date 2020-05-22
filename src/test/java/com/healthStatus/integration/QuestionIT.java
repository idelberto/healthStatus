package com.healthStatus.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.healthStatus.dtos.ErrorResponseDto;
import com.healthStatus.dtos.question.QuestionRequestDto;
import com.healthStatus.dtos.question.QuestionResponseDto;
import com.healthStatus.entities.enums.QuestionType;

@TestMethodOrder(OrderAnnotation.class)
public class QuestionIT extends BaseIT {

	@Test
	@DisplayName("Gravar uma uma pergunta")
	@Order(1)
	void persist() throws Exception {

		QuestionRequestDto requestDto = new QuestionRequestDto();
		requestDto.setTitle("Teve contato com alguém da área da saúde?");
		requestDto.setType(QuestionType.BOOLEAN);

		RequestBuilder requestBuilder = post("/v1/question")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(objectMapper.writeValueAsString(requestDto));

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		QuestionResponseDto responseDto = objectMapper//
				.readValue(response.getContentAsString(), QuestionResponseDto.class);

		assertNotNull(responseDto.getId());

	}

	@Test
	@DisplayName("Busca todas as questões cadastradas")
	@Order(2)
	void getQuestions() throws Exception {
		RequestBuilder requestBuilder = get("/v1/question");

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		CollectionType type = objectMapper//
				.getTypeFactory()//
				.constructCollectionType(List.class, QuestionResponseDto.class);

		List<QuestionResponseDto> responseDto = objectMapper.readValue(response.getContentAsString(), type);

		assertFalse(responseDto.isEmpty());

	}

	@Test
	@DisplayName("Atualizar uma questão")
	@Order(3)
	void updateQuestion() throws Exception {

		QuestionRequestDto requestDto = new QuestionRequestDto();
		requestDto.setTitle("Atualizado");
		requestDto.setType(QuestionType.TEXT);

		RequestBuilder requestBuilder = put("/v1/question/{id}", 1L).contentType(MediaType.APPLICATION_JSON)//
				.content(objectMapper.writeValueAsString(requestDto));

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		QuestionResponseDto responseDto = objectMapper//
				.readValue(response.getContentAsString(), QuestionResponseDto.class);

		assertEquals(1l, responseDto.getId());
		assertEquals("Atualizado", responseDto.getTitle());

	}

	@Test
	@DisplayName("Tentativa de atualizar uma questão que não existe")
	@Order(4)
	void updateNonexistentQuestion() throws Exception {

		QuestionRequestDto requestDto = new QuestionRequestDto();
		requestDto.setTitle("Atualizado");
		requestDto.setType(QuestionType.TEXT);

		RequestBuilder requestBuilder = put("/v1/question/{id}", 2L).contentType(MediaType.APPLICATION_JSON)//
				.content(objectMapper.writeValueAsString(requestDto));

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isNotAcceptable())//
				.andReturn()//
				.getResponse();

		ErrorResponseDto responseDto = objectMapper//
				.readValue(response.getContentAsString(StandardCharsets.UTF_8), ErrorResponseDto.class);

		assertEquals("Registro não encontrado", responseDto.getMessage());

	}

}
