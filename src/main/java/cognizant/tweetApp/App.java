package cognizant.tweetApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import cognizant.tweetApp.service.UserService;

public class App {
	static UserService userService = new UserService();

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		boolean isExist = false;
		while (!isExist) {
			System.out.println("\nWELCOME TO TWEET APP\n");
			System.out.println("\n\t 1.REGISTER \n\t 2.LOGIN \n\t 3.FORGET PASSWORD \nSELECT THE OPTIONS");
			int option = s.nextInt();
			if (option == 1) {
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
			if (option == 2) {
				System.out.println(
						"SELECT THE OPTIONS 1.TWEET \n\t 2.VIEW ALL TWEETS \n\t 3.VIEW MY TWEETS \n\t 4.VIEW ALL USERS \n\t 5.RESET PASSWORD \n\t 6.LOGOUT");
				int choice;
				choice = s.nextInt();
				switch (choice) {
				case 1:
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				default:
					break;
				}
				sc.readLine();
			}
			if (option == 3) {
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
			} else {
				System.err.println("Enter Valid Input");
				sc.readLine();
			}
		}
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
