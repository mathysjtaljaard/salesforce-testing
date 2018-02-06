package org.taljaard.nextgear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SalesforceTestingApplication {

	//Example from https://www.jamesward.com/2016/12/20/connecting-to-the-salesforce-rest-apis-with-spring-boot-and-java/
	public static void main(String[] args) {
		SpringApplication.run(SalesforceTestingApplication.class, args);
	}
}
