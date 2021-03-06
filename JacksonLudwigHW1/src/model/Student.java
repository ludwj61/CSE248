package model;

import java.util.ArrayList;
import java.util.Random;

public class Student {
	private static String idCounter = "00000000";

	private String firstName;
	private String lastName;
	private String id;
	private String username;
	private String password;
	private String gpa;

	public Student(ArrayList<String> firstNames, ArrayList<String> lastNames) {
		generateName(firstNames, lastNames);
		generateId();
		generateUsername();
		generatePassword();
		generateGpa();
	}

	private void generateName(ArrayList<String> firstNames, ArrayList<String> lastNames) {
		firstName = Utilities.getRandomFirstName(firstNames);
		lastName = Utilities.getRandomLastName(lastNames);
	}

	private void generateId() {
		int temp = Integer.parseInt(idCounter);
		id = String.format("%08d", temp);
		idCounter = String.valueOf(temp + 1);
	}

	private void generateUsername() {
		if (lastName.length() > 3) {
			username = lastName.substring(0, 4) + firstName.charAt(0) + id.charAt(id.length() - 1);
		} else {
			username = lastName.substring(0) + firstName.charAt(0) + id.charAt(id.length() - 1);
		}

		username = username.toLowerCase();
	}

	private void generatePassword() {
		if (lastName.length() > 3) {
			password = lastName.substring(0, 4) + firstName.charAt(0) + id.charAt(id.length() - 1);
		} else {
			password = lastName.substring(0) + firstName.charAt(0) + id.charAt(id.length() - 1);
		}

		password = password.substring(0, 1).toUpperCase() + password.substring(1).toLowerCase();
	}

	private void generateGpa() {
		double gpa = new Random().nextInt(400) / 100.0;
		this.gpa = String.valueOf(gpa);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", username=" + username
				+ ", password=" + password + ", gpa=" + gpa + "]";
	}

}
