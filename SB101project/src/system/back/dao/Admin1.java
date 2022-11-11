package system.back.dao;

import java.util.List;
import java.util.prefs.BackingStoreException;

import system.back.exceptions.AdminException;
import system.back.exceptions.BatchException;
import system.back.exceptions.CourseException;
import system.back.exceptions.StudentException;
import system.back.model.Admin;
import system.back.model.Batch;
import system.back.model.Course;
import system.back.model.StudentBatch;
import system.back.model.StudentDTO;

public interface Admin1 {
	
	public String adminRegistration(Admin admin) throws AdminException;
	
	public String login(String username , String password) throws AdminException;
	
	public String addCourse(Course course) throws CourseException;
	
	public String updateFees(int cid, int fee) throws CourseException;
	
	public String deletCourse(int cid) throws CourseException;
	
	public Course searchInfoCourse(String cname) throws CourseException;
	
	public String createBatch(Batch batch) throws BatchException;
	
	public String allocateStudent(StudentBatch sb) throws BatchException;
	
	public String updateSeat(int bid,int value) throws BatchException;
	
	public List<StudentDTO> viewStudentOfBatch() throws StudentException;



}
