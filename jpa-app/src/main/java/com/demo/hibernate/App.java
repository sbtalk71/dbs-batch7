package com.demo.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysql");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			Emp e= new Emp(109, "Ramu", "Mumbai", 65000);

			em.persist(e);
			tx.commit();
		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		}

		finally {
			em.close();
			emf.close();
		}

	}

}
