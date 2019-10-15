package com.demo.spring.impl;

import com.demo.spring.Writer;

public class PlainTextWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.println("Plain Text Writer : "+message);

	}

}
