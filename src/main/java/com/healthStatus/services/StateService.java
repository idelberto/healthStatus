package com.healthStatus.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthStatus.entities.State;
import com.healthStatus.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<State> list() {
		
		return repository.findAll();
				
	}
	
}
