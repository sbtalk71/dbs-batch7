package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

@Component
public class MyClientRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		// ResponseEntity<String>
		// response=rt.getForEntity("http://localhost:8080/emp/find/104", String.class);
		// System.out.println(response.getBody());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		
	

		/*
		 * HttpEntity req = new HttpEntity<>(headers);
		 * 
		 * ResponseEntity<String> response1 =
		 * rt.exchange("http://localhost:8080/emp/find/104", HttpMethod.GET, req,
		 * String.class);
		 * 
		 * System.out.println(response1.getBody());
		 */

		Emp emp = new Emp(222, "Kishan", "Hyderabad", 87000);

		HttpEntity req1 = new HttpEntity<>(emp, headers);

		ResponseEntity<String> response2 = rt.exchange("http://localhost:8080/emp/save", HttpMethod.POST, req1,
				String.class);

		System.out.println(response2.getBody());
	}

}
