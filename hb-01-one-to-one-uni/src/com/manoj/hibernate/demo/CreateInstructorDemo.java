package com.manoj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manoj.hibernate.demo.entity.Instructor;
import com.manoj.hibernate.demo.entity.InstructorDetails;

public class CreateInstructorDemo {

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
			//create a Instructor object
			Instructor tempInstructor=new Instructor("nag","king","ummanojkumar@gmail.com");
			
			//create a instructor details object
			InstructorDetails tempInstructorDetails=new InstructorDetails("https://youtube.com/manoj","fun-Tech-videos");
			
			//cascade two objects
			tempInstructor.setInstructorDetails(tempInstructorDetails);
			
			
			//start a trasaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempInstructor);
			
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
