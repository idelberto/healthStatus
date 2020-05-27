package com.healthStatus.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.healthStatus.dtos.user.UserRequestDto;
import com.healthStatus.dtos.user.UserResponseDto;

@TestMethodOrder(OrderAnnotation.class)
public class UserIT extends BaseIT
{
	
	static UserRequestDto anExistingUser()
	{
		
		UserRequestDto requestDto = new UserRequestDto();
		requestDto.setName("Rodrigo");
		requestDto.setUserName("rodrigo_barbosa");
		requestDto.setPassword("a12345678");
		
		return requestDto;
	}
	
	static UserRequestDto noExistingUser()
	{
		
		UserRequestDto requestDto = new UserRequestDto();
		requestDto.setName("Ian");
		requestDto.setUserName("iancesar");
		requestDto.setPassword("a12345678");
		
		return requestDto;
	}
	
	@Test
	@DisplayName("Gravar um usuário")
	@Order(1)
	void persist() throws Exception {
		
		RequestBuilder requestBuilder = post("/v1/user")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(objectMapper.writeValueAsString(anExistingUser()));

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		UserResponseDto responseDto = objectMapper//
				.readValue(response.getContentAsString(), UserResponseDto.class);

		assertNotNull(responseDto.getId());

	}
	
	@Test
	@DisplayName("Buscar todos usuários cadastrados")
	@Order(2)
	void getUsers() throws Exception {

		RequestBuilder requestBuilder = get("/v1/user");

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		CollectionType type = objectMapper//
				.getTypeFactory()//
				.constructCollectionType(List.class, UserResponseDto.class);

		List<UserResponseDto> responseDto = objectMapper.readValue(response.getContentAsString(), type);

		assertFalse(responseDto.isEmpty());

	}

	@Test
	@DisplayName("Atualizar a senha de um usuário")
	@Order(3)
	void updateQuestion() throws Exception {
		
		RequestBuilder requestBuilder = put("/v1/user/{id}", 1L).contentType(MediaType.APPLICATION_JSON)//
				.content(objectMapper.writeValueAsString(noExistingUser()));

		MockHttpServletResponse response = mvc.perform(requestBuilder)//
				.andExpect(status().isOk())//
				.andReturn()//
				.getResponse();

		UserResponseDto responseDto = objectMapper//
				.readValue(response.getContentAsString(), UserResponseDto.class);

		assertEquals(1l, responseDto.getId());
		assertEquals("Ian", responseDto.getName());
//
	}

}
