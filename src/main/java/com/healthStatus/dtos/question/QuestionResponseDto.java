package com.healthStatus.dtos.question;

import com.healthStatus.entities.enums.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponseDto {

	private Long id;

	private String title;

	private QuestionType type;

}
