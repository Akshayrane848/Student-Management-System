package com.masai.dao;

import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.CourseDTO;
import com.masai.model.Student;

public interface Student1 {
	
	public String studentRegistration(Student student) throws StudentException;
	
	public String login(String username , String password) throws StudentException;
	
	public String updateDetails(int roll, String field, String Data) throws StudentException;
	
	public List<CourseDTO> availableCourseSeat() throws CourseException;
	

}
