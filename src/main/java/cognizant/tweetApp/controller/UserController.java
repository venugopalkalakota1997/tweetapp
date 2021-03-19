package cognizant.tweetApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import cognizant.tweetApp.model.User;
import cognizant.tweetApp.service.UserService;

public class UserController {
	UserService userService = new UserService();

	TweetController tweetController = new TweetController();
	Scanner s = new Scanner(System.in);
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

	public void forgetpassword() throws IOException {
		System.out.println("For Password Enter the details below");
		System.out.println("User Email");
		String useremail = sc.readLine();
		System.out.println("DOB");
		String dob = sc.readLine();
		try {
			userService.getpassword(useremail, dob);

		} catch (Exception e) {
			System.err.println("Invalid Details");
		}
		sc.readLine();
	}

	public void signUp() throws IOException {
		System.out.println("\tSIGN UP\n");
		System.out.println("\n\t First Name:");
		String firstname = sc.readLine();
		System.out.println("\n\t Last Name:");
		String lastname = sc.readLine();
		System.out.println("\n\t Gender(Male/Female):");
		String gender = sc.readLine();
		System.out.println("\n\t DOB(dd-MM-yyyy):");
		String dob = sc.readLine();
		System.out.println("\n\t Email Address:");
		String useremail = sc.readLine();
		System.out.println("\n\t Password:");
		String password = sc.readLine();
		boolean va = validate(firstname, lastname, gender, dob, useremail, password);
		if (va) {
			try {
				userService.addUser(firstname, lastname, gender, dob, useremail, password);
				System.err.println("Success Registered");
			} catch (Exception e) {
				System.err.println("Invalid details");
			}
		}
		sc.readLine();
	}

	public void login() throws IOException {
		System.out.println("\t LOGIN DETAILS");
		System.out.println("\n\t User Email");
		String useremail = sc.readLine();
		System.out.println("\n\t Password");
		String password = sc.readLine();
		User u = new User();
		u.setEmail(useremail);
		u.setPassword(password);
		try {
			boolean usr = userService.login(u);

			if (usr)
				tweetController.tweet(u);
			else
				System.err.println("Invalid Details");

		} catch (SQLException e) {
			System.err.println("Invalid Details");
		}

		sc.readLine();

	}

	static boolean validate(String firstname, String lastname, String gender, String dob, String useremail,
			String password) {
		boolean valid = true;
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (firstname.isEmpty()) {
			valid = false;
			System.err.println("First Name is Required");
		}
		if (gender.isEmpty()) {
			valid = false;
			System.err.println("Gender is Required");
		}
		if (dob.isEmpty()) {
			valid = false;
			System.err.println("Incorrect  required");
		}
		if (useremail.isEmpty() || !useremail.matches(EMAIL_REGEX)) {
			valid = false;
			System.err.println("Invalid Email Format");
		}
		if (password.isEmpty()) {
			valid = false;
			System.err.println("Password Required");
		}
		return valid;
	}
}
