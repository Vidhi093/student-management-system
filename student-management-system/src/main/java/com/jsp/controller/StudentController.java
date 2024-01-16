package com.jsp.controller;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.model.Student;
import com.jsp.servlet.Database;

public class StudentController{
	
	Database database = new Database();

	public Student find(String username) {
		return Database.entityManager.find(Student.class, username);
		
	}
	
	public boolean registerStudent(Student student) {
		if (student!=null) {
			Database.entityTransaction.begin();
			Database.entityManager.persist(student);
			Database.entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	
	public boolean deleteStudentDetail(Student student) {
		if (student!=null) {
			Database.entityTransaction.begin();
			Database.entityManager.remove(student);
			Database.entityTransaction.commit();
			return true;
		}
		
		return false;
		
	}
	
	public boolean updateDetail(Student student) {
		if (student!=null) {
			Database.entityTransaction.begin();
			Database.entityManager.merge(student);
			Database.entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public boolean changePassword(Student student) {
		if (student!=null) {
			Database.entityTransaction.begin();
			Database.entityManager.merge(student);
			Database.entityTransaction.commit();
			return true;
		}
		return false;
	}

}
