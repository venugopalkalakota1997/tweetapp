package cognizant.tweetApp;

import java.util.Scanner;

import cognizant.tweetApp.service.UserService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println("\nWELCOME TO TWEET APP\n");

		System.out.println("SELECT THE OPTIONS 1.REGISTER \n\t 2.LOGIN \n\t 3.FORGET PASSWORD ");

		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println("\tSIGN UP\n");
			System.out.println("\n\t First Name:");
			String firstname=sc.nextLine();
			System.out.println("\n\t Last Name:");
			String lastname=sc.nextLine();
			System.out.println("\n\t Gender(Male/Female):");
			String gender =sc.nextLine();
			System.out.println("\n\t DOB(dd-MM-yyyy):");
			String dob=sc.nextLine();
			System.out.println("\n\t Email Address:");
			String useremail=sc.nextLine();
			System.out.println("\n\t Password:");
			String password=sc.nextLine();
			userService.addUser(firstname,lastname,gender,dob,useremail,password);
		} else if (option == 2) {
			
			System.out.println(
					"SELECT THE OPTIONS 1.TWEET \n\t 2.VIEW ALL TWEETS \n\t 3.VIEW MY TWEETS \n\t 4.VIEW ALL USERS \n\t 5.RESET PASSWORD \n\t 6.LOGOUT");
			int choice;
			choice=sc.nextInt();
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

		} else if (option == 3) {

		} else {

		}
	}
}
