package com.luv2code.hibernate.task.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.task.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			
			System.out.println("\nGetting employee with id = 1");
			
			session.beginTransaction();
			
			Employee tempEmployee = session.get(Employee.class, 1);
			
			System.out.println("Get complete: " + tempEmployee);
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		

	}

}
