package io.javabrains.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("First User");

		Address homeAddress = new Address();
		homeAddress.setStreet("Street Name");
		homeAddress.setCity("City Name");
		homeAddress.setState("State Name");
		homeAddress.setPincode("555677");
		
		user.setHomeAddress(homeAddress);
		user.setJoinedDate(new Date());
		user.setDescription("First user Description");
		
		//second user
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		
		Address address2 = new Address();
		address2.setStreet("Street Name");
		address2.setCity("City Name");
		address2.setState("State Name");
		address2.setPincode("555677");
		
		user2.setOfficeAddress(address2);
		user2.setJoinedDate(new Date());
		user2.setDescription("Second user Description");
		
		 //Hibernate API to save this objects to DB
        //Session factory is created only ONCE
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession(); //open a new session
		
		//create transaction
		session.beginTransaction(); //use this transaction to save Object.
		session.save(user); //pass the object to hibernate
		session.save(user2);
		
		 //end the transaction
		session.getTransaction().commit();
		
		//Closing the session
		session.close();
		
		//Retrieving Objects using session.get() ( using Hibernate APIs: )
		user = null;
		session = sessionFactory.openSession(); 
		session.beginTransaction(); 
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is: "+ user.getUserName());
		
	}

}
