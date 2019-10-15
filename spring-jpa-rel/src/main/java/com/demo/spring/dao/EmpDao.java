package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public String save(Emp e,int dno);
	public List<Emp> getEmpList();
	public Emp find(int id);
}
