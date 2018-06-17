package com.luv2code.hibernate.task.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.task.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			System.out.println("Chaning Employee Binay's Company");
			
			session.createQuery("update Employee set company='CPG' where firstName='Binay'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}

	}

}
