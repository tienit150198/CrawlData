
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Convert {
	public Date convertStringToSQLDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date;
		java.sql.Date sqlDate;
		try {
			date = sdf.parse(str);
			date = new Date(System.currentTimeMillis());
			sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;

		} catch (ParseException e) {
			e.getMessage();
		}
		return null;
	}

	public LocalDate convertStringToLocalDate(String text) {
		if (!text.trim().equals(""))
			return LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return LocalDate.MIN;
	}
}
