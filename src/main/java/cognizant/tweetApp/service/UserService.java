package cognizant.tweetApp.service;

import cognizant.tweetApp.model.User;

public class UserService {

	public void addUser(String firstname, String lastname, String gender, String dob, String useremail, String password) {
		
		String strDateRegEx = "\\d{2}-\\d{2}-\\d{4}";
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(firstname.isEmpty()) {
			System.err.println("First Name is Required");
		}
		else if(gender.isEmpty()) {
			System.err.println("Gender is Required");
		}
		else if (dob.matches(strDateRegEx) || dob!=null) {
			System.err.println("Incorrect Date Format or required");
		}
		else if (useremail.isEmpty() || useremail.matches(EMAIL_REGEX)) {
			System.err.println("Invalid Email Format");
		}
		else if(password.isEmpty()) {
			System.err.println("Password Required");
		}
		else {
			
		}
		
	}
	public void saveUser(String fname, String lname, String gender, String dob, String email, String pwd) throws Exception {
		User newUser = new User(fname, lname, gender, DateUtil.convertToDate(dob), email, pwd);
		repo.saveUser(newUser);
	}
}
