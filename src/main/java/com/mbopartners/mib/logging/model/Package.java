package com.mbopartners.mib.logging.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Package {
	private String id;
	private String service;
	private String message;
	@JsonProperty("request_payload")
	private String requestPayload;
	@JsonProperty("parent_package_id")
	private String parentPackageId;
	// private HashMap<String, String> headers = new HashMap<>();

	public Package() {};

	public Package(String id, String service, String message) {
		this.id = id;
		this.service = service;
		this.message = message;
		this.requestPayload = "";
	}
	public String getId() {
		return this.id;
	}
	public String getService() {
		return this.service;
	}
	public String getMessage() {
		return this.message;
	}
	public String getRequestPayload() {
		return this.requestPayload;
	}
	public String getParentPackageId() {
		return this.parentPackageId;
	}
	public void setId(String val) {
		this.id = val;
	}
	public void setService(String val) {
		this.service = val;
	}
	public void setMessage(String val) {
		this.message = val;
	}
	public void setRequestPayload(String val) {
		this.requestPayload = val;
	}
	public void setParentPackageId(String val) {
		this.parentPackageId = val;
	}
}
