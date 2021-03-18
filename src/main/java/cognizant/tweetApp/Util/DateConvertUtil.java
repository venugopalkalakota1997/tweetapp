package cognizant.tweetApp.Util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvertUtil {
	public static Date convertToDate(String date) {
		java.util.Date parsed = null;
		Date date1 = null;
		try {
			SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy");
			parsed = dateFormate.parse(date);
			date1 = new java.sql.Date(parsed.getTime());
		} catch (ParseException parseException) {
			System.out.println("invalid Date format... dd-MM-yyyy format");
		}
		return date1;
	}
}
