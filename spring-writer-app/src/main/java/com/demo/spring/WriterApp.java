package com.demo.spring;

public class WriterApp {
	private Writer writer;
	

	public void setWriter(Writer writer) {
		this.writer = writer;
	}


	public void printMessage(String message) {
		writer.write(message);
	}
}
