package cognizant.tweetApp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cognizant.tweetApp.Util.DateConvertUtil;
import cognizant.tweetApp.model.User;

public class UserRepo {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	DateConvertUtil dateConvertUtil = new DateConvertUtil();

	public User getUser(String username, String dob) throws Exception {
		connection = DbHandler.getConnection();
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT user_email, user_password from user where user_email = ? and user_dob=? ");
			preparedStatement.setString(1, username);
			preparedStatement.setDate(2, DateConvertUtil.convertToDate(dob));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String email = resultSet.getString("user_email");
				String password = resultSet.getString("user_password");
				System.err.println("Useremail: " + email + "  Password:" + password);
			} else {
				throw new Exception();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}
		return user;
	}

	public boolean addUser(User user) throws Exception {
		boolean s = false;
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO user (`user_f_nm`, `user_l_nm`, `user_gen`, `user_dob`, `user_email`, `user_password`)  VALUES (?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setDate(4, DateConvertUtil.convertToDate(user.getDob()));
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();
			s = true;
		} catch (SQLException e) {
			s = false;
			System.err.println("user already exits");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}
		return s;
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

	public boolean login(User us) {
		boolean islogged = false;
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT user_email from user where user_email = ? and user_password=? ");
			preparedStatement.setString(1, us.getEmail());
			preparedStatement.setString(2, us.getPassword());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("user_email");
				if (name == null) {
					islogged = false;
				} else {
					islogged = true;
				}
			}

		} catch (SQLException e) {
			System.err.println("Invalid Login Details");
			islogged = false;
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}
		return islogged;
	}

	public void resetPassword(String useremail, String npassword) {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE `user` SET `user_password` = ? WHERE (`user_email` = ?)");

			preparedStatement.setString(1, npassword);
			preparedStatement.setString(2, useremail);
			preparedStatement.executeUpdate();
			System.err.println("Password Reset Success");

		} catch (SQLException e) {
			System.err.println("Unable to Reset Password");
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}

	}

}
