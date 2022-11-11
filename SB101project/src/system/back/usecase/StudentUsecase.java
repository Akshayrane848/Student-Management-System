package system.back.usecase;

import java.util.List;
import java.util.Scanner;

import system.back.dao.Admin1;
import system.back.dao.AdminIMP;
import system.back.dao.Student1;
import system.back.dao.StudentIMP;
import system.back.exceptions.AdminException;
import system.back.exceptions.CourseException;
import system.back.exceptions.StudentException;
import system.back.model.Admin;
import system.back.model.CourseDTO;
import system.back.model.Student;
import system.back.model.StudentBatch;
import system.back.model.StudentDTO;

public class StudentUsecase {
	
	
	public static void studentRegistration() {
		
		Scanner sc= new Scanner(System.in);
		
		System.err.println("Enter student Details");
		
		System.out.println("-----------------------------------");
		
		
		System.out.println("Enter Name");
		String name= sc.nextLine();
		
		
		System.out.println("Enter adress");
		String adress = sc.next();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		
		Student student = new Student();
		
		student.setSname(name);
		student.setSaddress(adress);
		student.setSeamil(email);
		student.setPassward(pass);
		
		
		Student1 dao= new StudentIMP();
		
		
		try {
			String res= dao.studentRegistration(student);
			System.out.println(res);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static int login() {
		
		int x=0;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter Passward");
		String password = sc.next();
		
		Student1 dao= new StudentIMP();
		
		try {
			String res= dao.login(username, password);
			System.out.println(res);
			x=1;
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return x;
	}

	
	public static void updateDetails() {
	
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter roll");
		int roll= sc.nextInt();
		
		System.out.println("Enter field");
		String field = sc.next();
		
		System.out.println("Enter value");
		String value = sc.next();
		
		
		Student1 dao= new StudentIMP();
		
		try {
			String res= dao.updateDetails(roll, field, value);
			System.out.println(res);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void availableCourseSeat() {
		
		Student1 dao= new StudentIMP();
		
		
		try {
			List<CourseDTO> student= dao.availableCourseSeat();
			
			if(student.size() == 0 ) {
				System.out.println("No data found");
			}else
				student.forEach(s -> System.out.println(s));
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
			
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
