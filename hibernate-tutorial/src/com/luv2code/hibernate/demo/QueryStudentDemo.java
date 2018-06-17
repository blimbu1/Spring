package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		//Hibernate has a query language called HQL
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			// the statement returns all the student objects.
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			
			// display the students
			displayStudents(theStudents);
			
			//query students: lastName = 'Doe'
			//lastName is the object property not the column_name.
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			
			//display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			
			// query students: lastName = 'Doe' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'"
												+ " OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Doe or first name Daffy");
			displayStudents(theStudents);
		
			// the first query is required for us to be able to use the variable theStudents
			
			// query of students whose email ends with @gmail.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail%'").getResultList();
		
			System.out.println("\n\nStudents who have email @gmail.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
