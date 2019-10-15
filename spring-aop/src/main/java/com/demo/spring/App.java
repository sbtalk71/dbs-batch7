package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Performer singer = (Performer) ctx.getBean("singer");

		System.out.println(singer.getClass().getName());
		singer.perform();

	}

}
