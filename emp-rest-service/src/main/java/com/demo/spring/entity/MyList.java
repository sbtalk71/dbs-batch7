package com.demo.spring.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="emps")
public class MyList {
	
	private List<Emp> emp;

	public List<Emp> getEmpList() {
		return emp;
	}

	public void setEmpList(List<Emp> emp) {
		this.emp = emp;
	}

}
