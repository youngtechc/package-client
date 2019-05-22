package com.mbopartners.mib.logging.api;

import javax.ws.rs.client.Client;
// import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mbopartners.mib.logging.model.Package;

// import org.glassfish.jersey.client.ClientConfig;

import com.mbopartners.mib.logging.api.SnakeCaseProvider;

public class PackageClient {
	private static final String REST_URI = "http://localhost:8091/logging/packages";
	private Client client = new Client();

	// public PackageClient() {
	// 	ClientConfig clientConfig = new ClientConfig();
	// 	clientConfig.register(new SnakeCaseProvider());
	// 	this.client = ClientBuilder.newClient(clientConfig);
	// }
	
	public Package getJsonPackage(String id) {
		return this.client.target(REST_URI).path(id).request(MediaType.APPLICATION_JSON).get(Package.class);
	}
	
	public Response createJsonPackage(Package pkg) {
		return this.client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(pkg, MediaType.APPLICATION_JSON));
	}
}
