package com.luv2code.hibernate.task.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.task.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int employeeId = 2;
			
			// now get a session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting Employee with id: " + employeeId);
			
			Employee emp = session.get(Employee.class, employeeId);
			
			System.out.println("\nDeleting the employee" + emp);
			
			session.delete(emp);
			
			session.getTransaction().commit();
			
			
		}
		finally {
			
			factory.close();
		}

	}

}
