package com.br.healthtech.sandbox.spring.cloud.microservices.account;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.br.healthtech.sandbox.spring.cloud.microservices.account")
public class AccountConfiguration {

	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
}
