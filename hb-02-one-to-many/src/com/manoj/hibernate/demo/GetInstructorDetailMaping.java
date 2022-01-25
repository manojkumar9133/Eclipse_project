package com.manoj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manoj.hibernate.demo.entity.Instructor;
import com.manoj.hibernate.demo.entity.InstructorDetails;

public class GetInstructorDetailMaping {

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
			int theId=99;
			
			//start a trasaction
			session.beginTransaction();
			
			InstructorDetails tempInstructorDetails=session.get(InstructorDetails.class, theId);
			
			System.out.println("temmpInstructorDetails : "+tempInstructorDetails);
			
			System.out.println("calling Instructor : "+tempInstructorDetails.getInstructor());

		
			//commit transcation
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}

}
