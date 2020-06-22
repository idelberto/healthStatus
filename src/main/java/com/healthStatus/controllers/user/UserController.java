package com.healthStatus.controllers.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.healthStatus.dtos.user.UserRequestDto;
import com.healthStatus.dtos.user.UserResponseDto;

public interface UserController {

	public ResponseEntity<UserResponseDto> persist(UserRequestDto user);

	public ResponseEntity<List<UserResponseDto>> list();

	public ResponseEntity<UserResponseDto> update(Long id, UserRequestDto user);

	public ResponseEntity<UserResponseDto> userLogin(String username ,String password);

}
