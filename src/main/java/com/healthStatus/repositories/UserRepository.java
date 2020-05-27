package com.healthStatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthStatus.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
