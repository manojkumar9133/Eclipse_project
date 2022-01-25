package com.manoj.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manoj.hibernate.demo.entity.Course;
import com.manoj.hibernate.demo.entity.Instructor;
import com.manoj.hibernate.demo.entity.InstructorDetails;


public class CreateCourseDemo {

	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session=factory.getCurrentSession();
		
		try
		{
			int theId=1;
			//start a trasaction
			session.beginTransaction();
			
			//create a Instructor object
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			// create some courses
			Course tempCourse1=new Course("fist course");
			Course tmpCourse2=new Course("second course");
		
			// add some courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tmpCourse2);
			

			
			
			// 
			session.save(tempCourse1);
			session.save(tmpCourse2);
			
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
