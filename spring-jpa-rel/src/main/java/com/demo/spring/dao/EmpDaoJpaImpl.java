package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Dept;
import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public String save(Emp e, int dno) {
		Dept d = em.find(Dept.class, dno);

		e.setDept(d);
		em.persist(e);
		return "Emp Saved";
	}

	@Override
	public List<Emp> getEmpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
