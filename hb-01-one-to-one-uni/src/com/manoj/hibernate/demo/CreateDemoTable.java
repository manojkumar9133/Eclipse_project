package com.manoj.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manoj.hibernate.demo.entity.DemoTable;

public class CreateDemoTable {

	public static void main(String[] args) 
	{
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(DemoTable.class)
								.buildSessionFactory();
		
		// create session
		Session session=factory.getCurrentSession();
		
		try
		{
			//create a student object
			DemoTable tempDemo=new DemoTable("manoj","royal","ummanojkumar"
					+ "@gmail.com","demo0");
			
			
			//start a trasaction
			session.beginTransaction();
			
			//save the tempDemo object
			session.save(tempDemo);
			
			//commit transcation
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
		
	}

}
