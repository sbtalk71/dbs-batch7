package com.demo.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value=1)
public class GuestManager {

	public void welcomeGuest() {
		System.out.println("Please take your allotted seats..");
	}

	public void goodBye() {
		System.out.println("Thank you for comming. Please visit agaian..");
	}

	@Around("execution(* com.demo.spring.Performer.perf*(..))")
	public void apply(ProceedingJoinPoint pjp) throws Throwable {
		welcomeGuest();
		pjp.proceed();
		goodBye();
	}
}
