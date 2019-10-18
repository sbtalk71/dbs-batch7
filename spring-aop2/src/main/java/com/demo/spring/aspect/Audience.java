package com.demo.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value=2)
public class Audience {
	@Pointcut("execution(* com.demo.spring.Performer.perform(..))")
	private void pcut() {}

	@Before("pcut()")
	public void takeSeat() {
		System.out.println("The Audience taking seats...");
	}
	
	@Before("execution(* com.demo.spring.Performer.perform(..))")
	public void switchOffMobile() {
		System.out.println("The Audience switched off mobiles...");
	}
	
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("The Audience applauding..Clap-Clap-Clap...");
	}
}
