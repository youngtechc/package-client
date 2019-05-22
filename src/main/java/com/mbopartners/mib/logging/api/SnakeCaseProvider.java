package com.mbopartners.mib.logging.api;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Provider
public class SnakeCaseProvider implements ContextResolver<ObjectMapper> {
	private final ObjectMapper mapper;

	public SnakeCaseProvider() {
		mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
	}

	@Override
	public ObjectMapper getContext(Class<?> cls) {
		return mapper;
	}
}
