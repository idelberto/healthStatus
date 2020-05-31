package com.healthStatus.controllers.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthStatus.dtos.state.StateResponseDto;
import com.healthStatus.services.StateService;

@RestController
@RequestMapping(path = "/v1/state")
public class StateV1Controller implements StateController {
	
	@Autowired
	StateService stateService;
	
	@Override
	@GetMapping
	public ResponseEntity<List<StateResponseDto>> list()
	{
		return ResponseEntity.ok(stateService.list());
	}

}
