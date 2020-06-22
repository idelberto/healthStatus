package com.healthStatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthStatus.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1 AND u.password = ?2")
	User findLoggedUser(String userName, String password);
	
}
