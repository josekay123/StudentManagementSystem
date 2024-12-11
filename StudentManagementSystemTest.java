package main;
import java.io.IOException;
public class StudentManagementSystemTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  StudentManagementSystem sms = new StudentManagementSystem();

	        sms.addStudent(new Student("Alice", 20, "S001"));
	        sms.addStudent(new Student("Bob", 22, "S002"));
	        sms.addStudent(new Student("Charlie", 19, "S003"));

	        System.out.println("\nListing students:");
	        sms.listStudents();

	        String fileName = "students.txt";
	        try {
	            sms.saveToFile(fileName);
	            System.out.println("\nStudents saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        try {
	            sms.loadFromFile(fileName);
	            System.out.println("\nStudents loaded from " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        System.out.println("\nListing students after loading:");
	        sms.listStudents();
	    }
	
	}


