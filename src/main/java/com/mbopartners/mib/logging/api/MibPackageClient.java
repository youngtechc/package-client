package com.mbopartners.mib.logging.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mbopartners.mib.logging.model.MibPackage;

public class MibPackageClient {
	private String restUri = "http://localhost:8091/logging/packages";
	private Client client = ClientBuilder.newClient();

	public MibPackageClient(String uri, String auth, String pass) {
		restUri = uri;
	}
	
	public MibPackage getPackage(String id) {
		return client.target(restUri).path(id).request(MediaType.APPLICATION_JSON)
			.get(MibPackage.class);
	}
	
	public Response createPackage(MibPackage pkg) {
		return client.target(restUri).request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(pkg, MediaType.APPLICATION_JSON));
	}
}
