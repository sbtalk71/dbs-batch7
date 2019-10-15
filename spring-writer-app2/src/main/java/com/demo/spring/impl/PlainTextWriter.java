package com.demo.spring.impl;

import org.springframework.stereotype.Component;

import com.demo.spring.Writer;

@Component
public class PlainTextWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.println("Plain Text Writer : "+message);

	}

}
