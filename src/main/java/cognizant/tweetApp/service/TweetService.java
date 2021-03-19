package cognizant.tweetApp.service;

import java.util.List;

import cognizant.tweetApp.model.Tweet;
import cognizant.tweetApp.model.User;
import cognizant.tweetApp.repo.TweetRepo;

public class TweetService {
	TweetRepo tweetRepo = new TweetRepo();

	public List<Tweet> getAllTweets() {
		
		return tweetRepo.getAllTweets();

	}
	public List<User> getAllUsers(){
		return tweetRepo.getAllUsers();
	}
	public List<Tweet> getMyTweets(String useremail) {
		return tweetRepo.getMytweets(useremail);
	}
	public void postTweet(String useremail, String message) {
		tweetRepo.postTweet(useremail,message);
		
	}

}
