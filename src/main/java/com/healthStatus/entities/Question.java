package com.healthStatus.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.healthStatus.entities.enums.QuestionType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotNull
	@NotEmpty
	private String title;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private QuestionType type;

}
