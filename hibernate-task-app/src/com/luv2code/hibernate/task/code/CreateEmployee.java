package com.luv2code.hibernate.task.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.task.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new employee object .....");
			
			Employee tempemployee = new Employee("Yanib", "Limbu", "QA");
			
			Employee temp2 = new Employee("David", "Lee", "QA");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student......");
			session.save(tempemployee);
			session.save(temp2);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
					
		}
		finally {
			factory.close();
		}

	}

}
