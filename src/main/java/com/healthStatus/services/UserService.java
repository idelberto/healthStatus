package com.healthStatus.services;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthStatus.dtos.user.UserRequestDto;
import com.healthStatus.dtos.user.UserResponseDto;
import com.healthStatus.entities.User;
import com.healthStatus.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserResponseDto persist(UserRequestDto requestDto) {

		User user = modelMapper.map(requestDto, User.class);
		user = repository.save(user);
		return modelMapper.map(user, UserResponseDto.class);
	}
	
	public List<UserResponseDto> list() {
		Type listType = new TypeToken<List<UserResponseDto>>() {
		}.getType();

		return modelMapper.map(repository.findAll(), listType);
	}
	
	public UserResponseDto update(Long id, UserRequestDto requestDto) {

		repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

		User user = modelMapper.map(requestDto, User.class);
		user.setId(id);
		user = repository.save(user);
		return modelMapper.map(user, UserResponseDto.class);

	}
	
	public UserResponseDto loggedUser(UserRequestDto requestDto) {
		
		Type type = new TypeToken<UserResponseDto>() {
		}.getType();

		User user = repository.findLoggedUser(requestDto.getUserName(), requestDto.getPassword());
		
		if (user != null)
		{
			return modelMapper.map(user, type);
		}
		else
		{
			return null;
		}
			
		
	}

}
