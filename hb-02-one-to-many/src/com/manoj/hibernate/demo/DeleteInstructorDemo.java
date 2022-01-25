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
			int theId=10;
			
			//start a trasaction
			session.beginTransaction();
			
			InstructorDetails tempInstructorDetail=session.get(InstructorDetails.class, theId);
			
			//remove the associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetails(null);			
			
			//save the student object
			session.delete(tempInstructorDetail);
			
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
