package com.healthStatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthStatus.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
