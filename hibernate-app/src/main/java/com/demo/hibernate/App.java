package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e= new Emp(107, "Karan", "Mumbai", 65000);

			session.save(e);
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
