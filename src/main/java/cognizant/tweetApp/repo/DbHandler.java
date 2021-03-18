package cognizant.tweetApp.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler {
	public static Connection getConnection() {

		Connection connection = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tweet_app";
			String username = "root";
			String password = "root";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException classNotFoundException) {

			throw new RuntimeException("Class Not Found Exception caught");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new RuntimeException("SQL Exception caught");
		}
		return connection;
	}
}
