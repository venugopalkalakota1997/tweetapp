package cognizant.tweetApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import cognizant.tweetApp.controller.UserController;

public class App {

	static UserController usercontroller = new UserController();
	static Scanner s = new Scanner(System.in);
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, SQLException {

		boolean isExist = false;
		while (!isExist) {
			System.out.println("\nWELCOME TO TWEET APP");
			System.out.println("\n\t 1.REGISTER \n\t 2.LOGIN \n\t 3.FORGET PASSWORD \nSELECT THE OPTIONS");
			int option = s.nextInt();
			switch (option) {
			case 1:
				usercontroller.signUp();
				break;
			case 2:
				usercontroller.login();
				break;
			case 3:
				usercontroller.forgetpassword();
				break;
			default:
				System.err.println("Enter Valid Input");
				sc.readLine();
				break;

			}
		}

	}

}
