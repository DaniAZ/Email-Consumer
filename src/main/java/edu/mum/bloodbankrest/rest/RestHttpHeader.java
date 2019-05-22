package edu.mum.bloodbankrest.rest;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;

import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.service.UserCredentialsService;
import edu.mum.bloodbankrest.service.impl.UserCredentialServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;





@Component
public class RestHttpHeader {
	protected RestTemplate restTemplate;

	@Autowired
	UserCredentialsService userCredentialsService;
	
	public RestHttpHeader() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/*
	*		Set up authentication header
	*		PLUS JSON Accept header
	*/
	public HttpHeaders getHttpHeaders() {

		// KLUDGE to get Credentials...
		UserCredentials userCredentials =
				((UserCredentialServiceImpl)
				userCredentialsService).getUserCredentials();
		
//		String username = userCredentials.getUsername();
//		String password = userCredentials.getPassword();
		String username="Daniel";
		String password="Daniel";
		
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64( 
           auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );
		List<HttpMethod> methods;


		HttpHeaders requestHeaders = new HttpHeaders();
       // requestHeaders.setAccessControlAllowMethods(Collections.singletonList(HttpMethod.POST));
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set("Authorization", authHeader);
		return requestHeaders;
	}

	public HttpEntity<?> getHttpEntity() {
		return new HttpEntity(getHttpHeaders());
	}

}

