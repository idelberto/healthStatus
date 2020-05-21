package com.healthStatus.dtos;

import com.healthStatus.entities.enums.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

	private Long id;

	private String title;

	private QuestionType type;

}
