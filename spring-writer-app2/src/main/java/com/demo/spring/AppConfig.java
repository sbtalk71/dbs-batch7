package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.test.spring.PlainTextWriter1;

@Configuration
@ComponentScan(basePackages="com.demo")
public class AppConfig {

	@Bean
	public Writer ptw1() {
		return new PlainTextWriter1();
	}
}
