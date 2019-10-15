package com.demo.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query=session.createQuery("from Emp e where e.empId between 100 and 110");
			
			List<Emp> empList=query.list();
			for(Emp e:empList) {
				System.out.println(e.getEmpId()+" "+e.getName());
			}
			
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
