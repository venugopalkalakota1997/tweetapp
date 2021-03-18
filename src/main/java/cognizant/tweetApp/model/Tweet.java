package cognizant.tweetApp.model;

public class Tweet {
	private String tweet;
	private User userDetails;
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	public Tweet(String tweet, User userDetails) {
		super();
		this.tweet = tweet;
		this.userDetails = userDetails;
	}
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tweet [tweet=" + tweet + ", userDetails=" + userDetails + "]";
	}
	
}
