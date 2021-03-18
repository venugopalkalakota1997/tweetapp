package cognizant.tweetApp.service;

import cognizant.tweetApp.Util.DateConvertUtil;
import cognizant.tweetApp.model.User;
import cognizant.tweetApp.repo.UserRepo;

public class UserService {
	DateConvertUtil dateutil = new DateConvertUtil();
	UserRepo repo = new UserRepo();

	public void addUser(String firstname, String lastname, String gender, String dob, String useremail, String password)
			throws Exception {

		User user = new User(firstname, lastname, gender, dob, useremail, password);
		repo.addUser(user);

	}

	public void getpassword(String useremail, String dob) throws Exception {
		repo.getUser(useremail,dob);
		
	}

}
