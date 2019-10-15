package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class WriterApp {
	@Autowired
	@Qualifier("ptw1")
	private Writer writer;
	
	public void printMessage(String message) {
		writer.write(message);
	}
}
