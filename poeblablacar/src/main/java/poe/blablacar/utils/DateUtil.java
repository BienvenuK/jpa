package poe.blablacar.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date convert(Date jour, int heure, int minute) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(jour);
		cal.set(Calendar.HOUR, heure);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
