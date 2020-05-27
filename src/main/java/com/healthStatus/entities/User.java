package com.healthStatus.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long					id;

	@Column(length = 150)
	@NotNull
	@NotEmpty
	private String					name;
	
	@Column(length = 45)
	@NotNull
	private String					userName;
	
	@Column(length = 45)
	@NotNull
	private String					password;

}
