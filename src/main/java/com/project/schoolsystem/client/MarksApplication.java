package com.project.schoolsystem.client;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.MarksController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;

public class MarksApplication {
	public static void addMarks() throws InvalidRollNoException  {
		System.out.print("Enter the number of Students Marks:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Marks Details");
		for (int i = 0; i < number; i++) {
			Marks marks = new Marks();
			System.out.print("Enter the rollNo of Student:");
			int rollNo = sc.nextInt();
			sc.nextLine();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			System.out.print("Enter the Tamil Mark:");
			Integer tamil = sc.nextInt();
			System.out.print("Enter the English Mark:");
			Integer english = sc.nextInt();
			System.out.print("Enter the Maths Mark:");
			Integer maths = sc.nextInt();
			System.out.print("Enter the Science Mark:");
			Integer science = sc.nextInt();
			System.out.print("Enter the Social Science Mark:");
			Integer socialScience = sc.nextInt();
			System.out.print("Enter the EVS Mark:");
			Integer evs = sc.nextInt();
			marks.setStudentRollNo(rollNo);
			marks.setTamil(tamil);
			marks.setEnglish(english);
			marks.setMaths(maths);
			marks.setScience(science);
			marks.setSocialScience(socialScience);
			marks.setEvs(evs);
			marksController.addMarksDetails(marks);
		}
		System.out.println("Case 1: Adding Marks Details is Completed");
	}

	static MarksController marksController = new MarksController();

	static Logger logger=Logger.getLogger("MarksApplication.class");
	public static void main(String args[]) throws InvalidRollNoException,InvalidUserChoiceException {

		logger.info("In Marks Application");
		while (true) {
			System.out.println("====== Marks Application======");
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
				addMarks();
				break;
			}
			case 2: {
				System.out.println("Enter choice of retrieval");
				Marks marks = new Marks();
				List<Marks> marksList = new ArrayList<Marks>();
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Reading All Marks Details");
					marksList = marksController.readAllMarksDetails();
					for (Marks s : marksList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Markss Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Marks Details");
					marks = marksController.readMarksDetailsByStudentRollNo();
					System.out.println(marks);
					System.out.println("Case 2: Reading Marks Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Marks Details");
				try {
					marksController.updateMarksDetails();
				} catch (InvalidRollNoException | InvalidUserChoiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Case 3: Updating Markss Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Marks Details");
				try {
					marksController.deleteMarksDetails();
				} catch (InvalidRollNoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Case 4: Deleting Markss Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
