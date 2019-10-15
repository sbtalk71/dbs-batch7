package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoJpaImpl;
import com.demo.spring.entity.Emp;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpDao dao=(EmpDao)ctx.getBean("empDaoJpaImpl");
		
		System.out.println(dao.save(new Emp(113, "Pavan", "Hyderabad", 65000), 20));

	}

}
