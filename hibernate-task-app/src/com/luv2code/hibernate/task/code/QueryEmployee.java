package com.luv2code.hibernate.task.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.task.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Employee> emp = session.createQuery("from Employee").getResultList();
			
			System.out.println("Displaying all Employees!!!");
			
			displayRecords(emp);
			
			System.out.println("Displaying all students with last Name 'Limbu'");
			
			emp = session.createQuery("from Employee s where s.lastName = 'Limbu'").getResultList();
			
			displayRecords(emp);
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			
		}
		finally {
			
			factory.close();
		}
		

	}

	private static void displayRecords(List<Employee> emp) {
		for (Employee tempemployee:emp) {
			
			System.out.println(tempemployee);
		}
	}

}
