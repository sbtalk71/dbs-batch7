package com.demo.ws;

import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8181/cal", new Calculator());

	}

}
