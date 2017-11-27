package com.rest.dao.implemen;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.rest.dao.interf.IStudents;
import com.rest.exceptions.DaoException;
import com.rest.model.Students;

public class StudentDao implements IStudents {

	public void addStudent(Students student) throws DaoException {
		try {
			Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			System.out.println("entered into dao Connection");
			session.save(student);
			session.beginTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(1000, "Issuing The Accessing DataBase", "Data Accessing issue");
		}

	}

}
