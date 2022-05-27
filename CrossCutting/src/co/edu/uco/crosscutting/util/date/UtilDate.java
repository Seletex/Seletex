package co.edu.uco.crosscutting.util.date;

import java.sql.Date;


import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

public class UtilDate {
	
	private static final UtilDate INSTANCE = new UtilDate();
	
	public static UtilDate getUtilDate() {
		return INSTANCE;
	
	}
	
	public boolean isNull(Date date) {
		return getUtilObject().isNull(date);
	}
	
	
	public boolean isBetween(Date date, Date end) {
		return false;
		
	}
	

}
