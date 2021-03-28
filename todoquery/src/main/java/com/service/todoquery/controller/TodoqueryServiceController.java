package com.service.todoquery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RestController
@RequestMapping("/rest/todos")
public class TodoqueryServiceController {
	@Autowired
	RestTemplate restTemplate;

	// For consul service
	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/{username}")
	public List<String> getTodos(@PathVariable("username") final String userName) {

		/*
		 * ResponseEntity<List<String>> todoResponse =
		 * restTemplate.exchange("http://localhost:8181/rest/db/" + userName,
		 * HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() { });
		 */

		// Start for consul service integration
		URI baseUrl = discoveryClient.getInstances("todomanagement-service")
							.stream()
								.map(service -> service.getUri())
									.findFirst().map(url -> url.resolve("/rest/db/" + userName)).get();
		
		ResponseEntity<List<String>> todoResponse = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {});
		// End for consul integration

		
		return todoResponse.getBody();
	}

}
