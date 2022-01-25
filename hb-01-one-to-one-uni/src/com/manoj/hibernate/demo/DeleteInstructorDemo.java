package com.manoj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manoj.hibernate.demo.entity.Instructor;
import com.manoj.hibernate.demo.entity.InstructorDetails;

public class DeleteInstructorDemo {

	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		
		// create session
		Session session=factory.getCurrentSession();
		
		try
		{
			int theId=1;
			
			//start a trasaction
			session.beginTransaction();
			
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			
			//save the student object
			session.delete(tempInstructor);
			
			//commit transcation
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}

}
