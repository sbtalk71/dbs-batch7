package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		Emp m = (Emp) ctx.getBean("emp");
		System.out.println(m.getEmpId()+" "+m.getAddress().getCity()+" "+m.getName().getFirstName());

	}

}
