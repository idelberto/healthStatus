package com.healthStatus.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.healthStatus.dtos.state.StateResponseDto;

@TestMethodOrder(OrderAnnotation.class)
public class StateIT extends BaseIT {
	
	@Test
	@DisplayName("Buscar todos os estados cadastrados")
	void getUsers() throws Exception {
		
		RequestBuilder requestBuilder = get("/v1/state");
		
		
		MockHttpServletResponse response = mvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse();

		CollectionType type = objectMapper
				.getTypeFactory()
				.constructCollectionType(List.class, StateResponseDto.class);

		List<StateResponseDto> responseDto = objectMapper.readValue(response.getContentAsString(), type);
		
		//RN.
		//Validando importação liquibase.
		if (responseDto.size() != 26)
		{
			assertFalse(true);
		}

		assertFalse(responseDto.isEmpty());
		
	}
	
}
