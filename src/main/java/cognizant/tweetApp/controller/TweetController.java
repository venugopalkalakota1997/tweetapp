package cognizant.tweetApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import cognizant.tweetApp.model.Tweet;
import cognizant.tweetApp.model.User;
import cognizant.tweetApp.service.TweetService;
import cognizant.tweetApp.service.UserService;

public class TweetController {
	TweetService tweetService = new TweetService();
	UserService userService = new UserService();
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	Scanner s = new Scanner(System.in);
	int i = 1;

	public void tweet(User u) throws IOException {
		boolean isvaild = false;
		while (!isvaild) {
			System.out.println(
					"SELECT THE OPTIONS \n\t 1.TWEET \n\t 2.VIEW ALL TWEETS \n\t 3.VIEW MY TWEETS \n\t 4.VIEW ALL USERS \n\t 5.RESET PASSWORD \n\t 6.LOGOUT");
			int choice;
			choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println(" POST A TWEET ");
				System.out.println("\t Enter the Tweet Message");
				String message = sc.readLine();
				tweetService.postTweet(u.getEmail(), message);
				System.err.println("Tweet Posted Successfully");
				sc.readLine();
				break;
			case 2:
				List<Tweet> tweets = tweetService.getAllTweets();
				if (tweets.isEmpty()) {
					System.err.println("No Records Found");
				} else {
					System.err.println("\t TWEET DETAILS \n");
					System.err.println("\t Sno \t TWEETS");
					i = 1;
					tweets.forEach(t -> {

						System.out.println("\t " + i++ + "\t " + t.getTweet());
					});
				}
				sc.readLine();
				break;
			case 3:
				List<Tweet> mytweets = tweetService.getMyTweets(u.getEmail());
				if (mytweets.isEmpty()) {
					System.err.println("No Records Found");
				} else {
					System.err.println("\t MY TWEET DETAILS\n");
					System.err.println("\t Sno \t TWEETS");
					i = 1;
					mytweets.forEach(t -> {

						System.out.println("\t " + i++ + "\t " + t.getTweet());
					});
				}
				sc.readLine();
				break;
			case 4:
				i = 1;
				List<User> users = tweetService.getAllUsers();
				if (users.isEmpty()) {
					System.err.println("No Records Found");
				} else {
					System.err.println("\t USER DETAILS");
					System.err.println("\t Sno \t User \n");

					users.forEach(us -> {
						System.out.println("\t " + i++ + "\t " + us.getEmail());
					});
				}
				sc.readLine();
				break;
			case 5:
				System.out.println("\t Reset Password ");
				System.out.println("\t Enter Current Password");
				String cpassword = sc.readLine();
				System.out.println("\t Enter New Password");
				String npassword = sc.readLine();
				if (cpassword.equals(u.getPassword())) {
					userService.resetPassword(u.getEmail(), npassword);

				} else
					System.err.println("Current Password is Incorrect");
				sc.readLine();
				break;
			case 6:
				Tweet t = new Tweet();
				u.setEmail(null);
				t.setUserDetails(null);
				t.setTweet(null);
				System.err.println("Logged out Successfully");
				isvaild = true;
				break;
			default:
				System.err.println("Enter Valid Input");
				sc.readLine();
				break;
			}
		}
	}
}
