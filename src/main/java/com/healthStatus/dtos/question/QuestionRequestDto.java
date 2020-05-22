package com.healthStatus.dtos.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.healthStatus.entities.enums.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequestDto
{

	@NotNull
	@NotEmpty
	private String			title;

	@NotNull
	private QuestionType	type;

}
