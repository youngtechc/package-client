package com.mbopartners.mib.logging;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mbopartners.mib.logging.model.MibPackage;
import com.mbopartners.mib.logging.api.MibPackageClient;

import org.junit.Test;

public class PackageClientLiveTest {
	public static final int HTTP_CREATED = 201;
	private static final String REST_URI = "http://localhost:8091/logging/packages";
	private MibPackageClient client = new MibPackageClient(REST_URI, "", "");

	@Test
	public void
	givenCorrectObject_whenCorrectJsonRequest_thenResponseCodeCreated() {
		String randomGuid = UUID.randomUUID().toString().replace("-", "");
		MibPackage p = new MibPackage(randomGuid, "connect", "opportunity", "{\"foo\":\"bar\"}");
		Response response = client.createPackage(p);
		assertEquals(HTTP_CREATED, response.getStatus());
	}

	@Test
	public void getPackageById() {
		MibPackage p = client.getPackage("0010f210667811e9a4190a89d826466e");
		assertEquals(p.getId(), "0010f210667811e9a4190a89d826466e");
	}

	@Test
	public void testSimpleExample() {
		String id = "0010f210667811e9a4190a89d826466e";
		String restURI = "http://localhost:8091/logging/packages/" + id;
		Client _client = ClientBuilder.newClient();

		MibPackage package1 = _client.target(restURI).request(MediaType.APPLICATION_JSON).get(MibPackage.class);
		System.out.println("Payload response: " + package1.getRequestPayload());
		assertEquals(id, package1.getId());
		assertEquals("{\"foo\":\"bar\"}", package1.getRequestPayload());
	}
}
