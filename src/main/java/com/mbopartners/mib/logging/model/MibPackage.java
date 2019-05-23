package com.mbopartners.mib.logging.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MibPackage {
	private String id;
	private String service;
	private String message;
	@XmlElement(name="request_payload")
	private String requestPayload;
	@XmlElement(name="parent_package_id")
	private String parentPackageId;
	private HashMap<String, String> headers;
	private HashMap<String, String> properties;

	public MibPackage() {};

	public MibPackage(String id, String service, String message) {
		this.id = id;
		this.service = service;
		this.message = message;
		this.requestPayload = "";
		this.headers = null;
		this.properties = null;
	}
	public MibPackage(String id, String service, String message, String requestPayload) {
		this(id, service, message);
		this.requestPayload = requestPayload;
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
	public HashMap<String, String> getProperties() {
		return properties;
	}
	public HashMap<String, String> getHeaders() {
		return this.headers;
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
	public void setHeaders(HashMap<String, String> val) {
		this.headers = val;
	}
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
}
