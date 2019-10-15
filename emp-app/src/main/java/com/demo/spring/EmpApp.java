package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class EmpApp {

	@Autowired
	private EmpDao dao;

	public String registerEmp(int id, String name, String city, double salary) {
		return dao.save(new Emp(id, name, city, salary));
	}

	public List<Emp> listAll() {
		return dao.getEmpList();
	}

	public String getEmpDetails(int id) {
		Emp e = dao.find(id);
		if (e != null) {
			return "" + e.getEmpId() + " " + e.getName() + " " + e.getCity() + " " + e.getSalary();
		} else {
			return "Emp Not Found";
		}
	}
}
