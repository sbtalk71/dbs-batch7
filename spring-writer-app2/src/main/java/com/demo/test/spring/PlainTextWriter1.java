package com.demo.test.spring;

import org.springframework.stereotype.Component;

import com.demo.spring.Writer;


public class PlainTextWriter1 implements Writer {

	@Override
	public void write(String message) {
		System.out.println("Plain Text Writer : "+message);

	}

}
