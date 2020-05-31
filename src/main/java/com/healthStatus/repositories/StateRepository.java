package com.healthStatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthStatus.entities.State;

public interface StateRepository extends JpaRepository<State, Long>
{

}
