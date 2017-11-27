package com.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.dao.implemen.StudentDao;
import com.rest.dao.interf.IStudents;
import com.rest.exceptions.DaoException;
import com.rest.exceptions.ServiceException;
import com.rest.model.Students;

@Path("Student")
public class ActionController {

	@GET
	@Path("gatName")
	public Response getName(@QueryParam("bbc") String name) {
		System.out.println("entered in service" + name);

		return Response.status(200).entity(name).build();

	}

	@GET
	@Path("getStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent() {
		Students student = new Students();
		student.setId(101);
		student.setName("Raju");
		student.setCollege("chts");
		return Response.status(200).entity(student).build();
	}

	@POST
	@Path("addStd")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Students student) {
		System.out.println("entered addStudent" + student.getCollege());
		try {
			String s=null;//to create error in service side then coming to catch block exception in service side
			s.length();
			IStudents std = new StudentDao();
			std.addStudent(student);
			return Response.status(200).entity(student).build();
		} catch (DaoException e) {
			return Response.status(550).entity(e).build();
		} catch (Exception e) {
			return Response.status(555)
					.entity(new ServiceException(1001, "isuue in serviceside", "service connection failed")).build();
		}
	}

}
