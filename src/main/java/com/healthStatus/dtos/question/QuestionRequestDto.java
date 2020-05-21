package com.healthStatus.dtos.question;

import com.healthStatus.entities.enums.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequestDto {

	private String title;

	private QuestionType type;

}
