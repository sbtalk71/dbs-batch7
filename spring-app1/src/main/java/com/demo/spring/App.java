package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		Mail m= (Mail)ctx.getBean("myMail");
		
		System.out.println(m.getMessage().getBody());
	}

}
