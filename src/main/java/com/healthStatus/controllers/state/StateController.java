package com.healthStatus.controllers.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthStatus.entities.State;
import com.healthStatus.services.StateService;

@RequestMapping("/state")
@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@GetMapping
	public ResponseEntity<List<State>> list() 
	{
		return ResponseEntity.ok(stateService.list());
	}

}
