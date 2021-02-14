package com.wolox.challenge.logical;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public interface IRestExternalRequest {
	void invoke();
	void getAllData(Object[] object, String url);
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder);
}
