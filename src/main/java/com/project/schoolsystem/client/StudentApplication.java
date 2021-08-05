package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.StudentController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Student;

public class StudentApplication {
	public static void addStudent() throws InvalidRollNoException {
		System.out.println("Enter the number of Students");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Students Details");
		for (int i = 0; i < number; i++) {
			Student student = new Student();
			int rollNo = sc.nextInt();
			sc.nextLine();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll NO is Invalid");
			}
			String name = sc.nextLine();
			String address = sc.nextLine();
			String dob = sc.nextLine();
			String standard = sc.nextLine();
			int roomNo = sc.nextInt();
			int id = sc.nextInt();
			student.setStudent_rollNo(rollNo);
			student.setStudent_name(name);
			student.setStudent_dob(dob);
			student.setStudent_address(address);
			student.setStudent_standard(standard);
			student.setClasses_roomNo(roomNo);
			student.setSchool_id(id);
			studentController.addStudentDetails(student);
		}
		System.out.println("Case 1: Adding Students Details is Completed");
	}

	static StudentController studentController = new StudentController();

	// static Logger logger=Logger.getLogger("StudentApplication.class");
	public static void main(String args[]) throws InvalidRollNoException, InvalidUserChoiceException {

		// logger.info("In Student Application");
		while (true) {
			System.out.println("====== Student Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("3.======Updation======");
			System.out.println("4.======Deletion======");
			System.out.println("Enter your choice");
			Scanner scanner = new Scanner(System.in);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				addStudent();
				break;
			}
			case 2: {
				System.out.println("Enter choice of retrieval");
				Student student = new Student();
				List<Student> studentList = new ArrayList<Student>();
				Scanner sc = new Scanner(System.in);
				int readChoice = sc.nextInt();
				switch (readChoice) {
				case 1: {
					System.out.println("Reading All Student Details");
					studentList = studentController.readAllStudentDetails();
					for (Student s : studentList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Students Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Student Details");
					student = studentController.readStudentDetailsById();
					System.out.println(student);
					System.out.println("Case 2: Reading Student Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Students Details");
				studentController.updateStudentDetails();
				System.out.println("Case 3: Updating Students Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Student Details");
				studentController.deleteStudentDetails();
				System.out.println("Case 4: Deleting Students Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
