package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "emp saved";
	}

	@Override
	public List<Emp> getEmpList() {
		Query query=em.createQuery("select e from Emp e");
		return query.getResultList();
	}

	@Override
	public Emp find(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

}
