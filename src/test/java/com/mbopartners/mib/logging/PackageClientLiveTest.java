package com.mbopartners.mib.logging;

import static org.junit.Assert.*;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mbopartners.mib.logging.api.PackageClient;
import com.mbopartners.mib.logging.model.Package;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;

public class PackageClientLiveTest {
	public static final int HTTP_CREATED = 201;
	private PackageClient client = new PackageClient();

	@Test
	public void givenCorrectObject_whenCorrectJsonRequest_thenResponseCodeCreated() {
		Package p = new Package("4c9bde70782411e9a3854c32759aaa45", "connect", "opportunity");
		Response response = client.createJsonPackage(p);
		assertEquals(HTTP_CREATED, response.getStatus());
	}

	@Test
	public void getPackageById() {
		Package p = client.getJsonPackage("0010f210667811e9a4190a89d826466e");
		assertEquals(p.getId(), "0010f210667811e9a4190a89d826466e");
	}

	@Test
	public void testSnakeCaseMapper() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		Package p = new Package("abcd", "connect", "opportunity");
		System.out.println(objectMapper.writeValueAsString(Entity.entity(p, MediaType.APPLICATION_JSON)));
	}
}
