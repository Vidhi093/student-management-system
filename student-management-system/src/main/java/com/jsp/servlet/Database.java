package com.jsp.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.jsp.model.Student;

@WebServlet(value = "/DB" ,loadOnStartup = 1)
public class Database extends HttpServlet{
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Database() {
		System.out.println("database connected");
	}
}
