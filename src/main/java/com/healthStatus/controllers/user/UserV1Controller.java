package com.healthStatus.controllers.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthStatus.dtos.user.UserRequestDto;
import com.healthStatus.dtos.user.UserResponseDto;
import com.healthStatus.services.UserService;

@RestController
@RequestMapping(path = "/v1/user")
public class UserV1Controller implements UserController
{

		
	@Autowired
	UserService service;
	
	@Override
	@PostMapping
	public ResponseEntity<UserResponseDto> persist(@Valid @RequestBody UserRequestDto user) 
	{	
		return ResponseEntity.ok(service.persist(user)); 	
	}

	@Override
	@GetMapping
	public ResponseEntity<List<UserResponseDto>> list() 
	{
		return ResponseEntity.ok(service.list());
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponseDto> update(@Valid @PathVariable("id") Long id, @RequestBody UserRequestDto user)
	{
 		return ResponseEntity.ok(service.update(id, user));
	}

}
