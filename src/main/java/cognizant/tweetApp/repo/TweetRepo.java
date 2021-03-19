package cognizant.tweetApp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cognizant.tweetApp.model.Tweet;
import cognizant.tweetApp.model.User;

public class TweetRepo {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	List<Tweet> tweets = new ArrayList<Tweet>();
	List<User> users = new ArrayList<User>();
	List<Tweet> mytweets = new ArrayList<Tweet>();

	public List<Tweet> getAllTweets() {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT message from tweet");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String message = resultSet.getString("message");
				Tweet tweet = new Tweet(message, null);
				tweets.add(tweet);
			}

		} catch (SQLException e) {
			System.err.println("No Records Found");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}

		return tweets;
	}

	public List<Tweet> getMytweets(String useremail) {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT message from tweet where us_email=?");
			preparedStatement.setString(1, useremail);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String message = resultSet.getString("message");
				Tweet tweet = new Tweet(message, null);
				mytweets.add(tweet);
			}

		} catch (SQLException e) {

			System.err.println("No Records Found");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}

		return mytweets;
	}

	public List<User> getAllUsers() {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT user_f_nm,user_email from user");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String userfname = resultSet.getString("user_f_nm");
				String useremail = resultSet.getString("user_email");
				User user = new User();
				user.setFirstname(userfname);
				user.setEmail(useremail);
				users.add(user);
			}

		} catch (SQLException e) {
			System.err.println("No Records Found");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}

		return users;
	}

	public void postTweet(String useremail, String message) {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO Tweet (us_email,message)  VALUES (?,?)");
			preparedStatement.setString(1, useremail);
			preparedStatement.setString(2, message);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Unable to post a tweet");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}
	}

	public void closedb() throws SQLException {

		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
