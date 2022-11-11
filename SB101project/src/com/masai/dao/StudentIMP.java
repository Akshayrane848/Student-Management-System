package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.CourseDTO;
import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class StudentIMP implements Student1 {

	@Override
	public String studentRegistration(Student student) throws StudentException {
		String massege = "Not Register";
		
		try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO student(sname,saddress,semail,password) VALUE(?,?,?,?)");
			
			ps.setString(1, student.getSname());
			ps.setString(2, student.getSaddress());
			ps.setString(3, student.getSeamil());
			ps.setString(4, student.getPassward());
			
			int x= ps.executeUpdate();
			
			if(x > 0) {
				
				massege = "Register successfully";
			}else
				throw new StudentException("invalid details");
				
			
		} catch (SQLException e) {
			// TODO: handle exception
			massege = e.getMessage();
			
			throw new StudentException(massege);
		}
		
		return massege;
	}

	@Override
	public String login(String username, String password) throws StudentException {
		
		String massege = "Login fail";
		
		try (Connection conn= DBUtil.provideConnection()){
		
		PreparedStatement ps= conn.prepareStatement("SELECT * FROM student WHERE username = ? and password = ?");
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			massege = "Login successfully";
		}
		else
		
		throw new StudentException("Invaid username or password");
		
		} catch (SQLException e) {
			// TODO: handle exception
			massege = e.getMessage();
		
			throw new StudentException(massege);
		}
	
		return massege;
	}

	@Override
	public String updateDetails(int roll, String field, String Data) throws StudentException {
String massege = "Not update";
		
		try (Connection conn= DBUtil.provideConnection()){
		
		PreparedStatement ps= conn.prepareStatement("UPDATE student set "+field+"=? WHERE roll = ?");
		
		ps.setString(1,Data);
		ps.setInt(2, roll);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			massege = "update successfully";
		}
		else
		
		throw new StudentException("Invaid field or roll ");
		
		} catch (SQLException e) {
			// TODO: handle exception
			massege = e.getMessage();
		
			throw new StudentException(massege);
		}
	
		return massege;
	}

	@Override
	public List<CourseDTO> availableCourseSeat() throws CourseException {
		List<CourseDTO> course = new ArrayList<>();
		
		try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("SELECT c.cid,c.cname,sum(b.bseats) FROM batch b INNER JOIN course c ON c.cid = b.cid GROUP BY c.cid");
			
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			while (rs.next()) {
				flag = false;
				
				CourseDTO cour = new CourseDTO(rs.getInt("bseats") ,rs.getInt("cid"),rs.getString("cname"));
				course.add(cour);
			}
			
			if(flag) 
				throw new  CourseException("course not available");
			
			} catch (SQLException e) {
				// TODO: handle exception
				
			
				throw new CourseException(e.getMessage());
			}
		
		return course;
	}

}
