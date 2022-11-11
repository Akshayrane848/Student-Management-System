package system.back.dao;

import java.util.List;

import system.back.exceptions.CourseException;
import system.back.exceptions.StudentException;
import system.back.model.CourseDTO;
import system.back.model.Student;

public interface Student1 {
	
	public String studentRegistration(Student student) throws StudentException;
	
	public String login(String username , String password) throws StudentException;
	
	public String updateDetails(int roll, String field, String Data) throws StudentException;
	
	public List<CourseDTO> availableCourseSeat() throws CourseException;
	

}
