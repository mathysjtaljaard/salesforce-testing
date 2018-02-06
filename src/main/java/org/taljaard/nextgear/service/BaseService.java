package org.taljaard.nextgear.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public abstract class BaseService {

	@Value("${saleforce.rest.version}")
	private String REST_VERSION;

	@Autowired
	protected OAuth2RestTemplate restTemplate;
	
	protected OAuth2Authentication principal;
	
	public BaseService() {
	}
	
	@SuppressWarnings("unchecked")
	protected String restUrl(OAuth2Authentication principal) {
		HashMap<String, Object> details = (HashMap<String, Object>) principal.getUserAuthentication().getDetails();
		HashMap<String, String> urls = (HashMap<String, String>) details.get("urls");
		return urls.get("rest").replace("{version}", REST_VERSION);
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	protected static class QueryResult<T> {
		public List<T> records;
	}

}
