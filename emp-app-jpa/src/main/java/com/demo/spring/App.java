package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		EmpApp app=ctx.getBean(EmpApp.class);
		
		//String resp = app.registerEmp(105, "Kiran", "Hyderabad", 89000);
		//System.out.println(resp);
		
		for(Emp e: app.listAll()) {
			System.out.println(e.getEmpId()+" "+e.getName());
		}
		
		

		System.out.println(app.getEmpDetails(104));
	}

}
