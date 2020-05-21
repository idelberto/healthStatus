package com.healthStatus.factory;

import org.modelmapper.ModelMapper;

/**
 * Aplica o Design Patter de Factory para se caso seja necessario configurações
 * mais complexas no Model Mapper
 * 
 * @author ian
 *
 */
public class ModelMapperFactory {

	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
