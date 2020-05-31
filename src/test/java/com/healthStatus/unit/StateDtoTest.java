package com.healthStatus.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.healthStatus.dtos.state.StateResponseDto;
import com.healthStatus.entities.State;
import com.healthStatus.factory.ModelMapperFactory;

public class StateDtoTest {
	
	@Test
	@DisplayName("Conversão de State para StateResponseDto")
	void stateToStateDto() throws Exception {
		
		ModelMapper mapper = new ModelMapperFactory().getModelMapper();

		State state = new State();
		state.setId(1l);
		state.setName("Estado Teste");
		state.setAbbreviation("ET");

		StateResponseDto dtoState = mapper.map(state, StateResponseDto.class);

		assertEquals(state.getId()			, dtoState.getId()		    );
		assertEquals(state.getName()		, dtoState.getName()	    );
		assertEquals(state.getAbbreviation(), dtoState.getAbbreviation());
		
	}

}
