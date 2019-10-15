package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		WriterApp app=ctx.getBean(WriterApp.class);
		
		app.printMessage("Hello Spring");
		
		WriterApp app1=ctx.getBean(WriterApp.class);
		
		System.out.println(app==app1);
		

	}

}
