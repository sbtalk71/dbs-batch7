package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FinderMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e=session.get(Emp.class, 104);
			System.out.println(e.getEmpId()+" "+e.getName());
			tx.commit();
		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		}

		finally {
			session.close();
			sf.close();
		}

	}

}
