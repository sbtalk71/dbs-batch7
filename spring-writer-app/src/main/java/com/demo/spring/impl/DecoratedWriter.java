package com.demo.spring.impl;

import com.demo.spring.Writer;

public class DecoratedWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.println("Decorated Text Writer : "+message);

	}

}
