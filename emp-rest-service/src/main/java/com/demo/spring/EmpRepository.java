package com.demo.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Query("select e from Emp e where e.city=?1")
	public List<Emp> findAllInCity(String city);
	
	@Query("select e from Emp e where e.salary between ?1 and ?2")
	public List<Emp> findAllWithSal(Double s1,Double s2);
}
