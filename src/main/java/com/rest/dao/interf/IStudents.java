package com.rest.dao.interf;

import com.rest.exceptions.DaoException;
import com.rest.model.Students;

public interface IStudents {
	public void addStudent(Students student)  throws DaoException;

}
