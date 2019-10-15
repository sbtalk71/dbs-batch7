package com.demo.spring;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.spring.entity.Emp;

@Component
public class EmpFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(Emp.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp=(Emp)target;
		if(emp.getEmpId()<=0) {
		errors.rejectValue("empId","idError","Id cannot be less than 0 or 0");
		}
		if(emp.getName().length()<5||emp.getName().length()<=0) {
			errors.rejectValue("name", "nameError", "Name must be min 5 chars");
		}

	}

}
