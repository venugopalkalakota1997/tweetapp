package cognizant.tweetApp.Util;

public class DateConvertUtil {
	
	Date parsedDate = null;
	try {
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy");
		dateFormate.setLenient(false);
		parsedDate = dateFormate.parse(date);
	} catch (ParseException parseException) {
		System.out.println("invalid Date format... please enter the DateOfBirth "+BatchConstants.DOB_FORMAT +" format");
	}
	return parsedDate;
}
