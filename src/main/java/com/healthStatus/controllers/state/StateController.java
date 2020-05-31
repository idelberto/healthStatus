package com.healthStatus.controllers.state;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.healthStatus.dtos.state.StateResponseDto;

public interface StateController {
	
	public ResponseEntity<List<StateResponseDto>> list();

}
