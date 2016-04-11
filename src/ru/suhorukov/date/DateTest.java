package ru.suhorukov.date;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		System.out.println(System.currentTimeMillis());
		Date anotherDate = new Date(-1905, 17, 14);// + 1900 лет
		System.out.println(date.compareTo(anotherDate));
		System.out.println(date.after(new Date()));
		
		Calendar calendar = Calendar.getInstance();
//		calendar = new GregorianCalendar();
		Date calendarTime = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		calendar.add(Calendar.MONTH, 5);
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println(((GregorianCalendar) calendar).isLeapYear(calendar.get(Calendar.YEAR)));
		System.out.println(calendar.getTime().getTime()); //ms
		
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		
		DateFormat dateFormat = DateFormat.getInstance();
		System.out.println(dateFormat.format(new Date()));
		
//		DateFormat customDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//		System.out.println(customDateFormat.format(new Date()));
		
		DateFormat customDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		System.out.println(customDateFormat.format(new Date()));
		
		Date customDate = customDateFormat.parse("05.06.2016 21:59:46");
		System.out.println(customDate);
		
		NumberFormat format = new DecimalFormat("###,###,###.###");
		System.out.println(format.format(35454.25));
		System.out.println(format.format(35454));
		
		LocalDate localTime = LocalDate.now();
		System.out.println(localTime);
		
		LocalDate particularDate = LocalDate.of(2016, 5, 9);
		System.out.println(particularDate);
		String dateStr = localTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.println(dateStr);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
		
		LocalTime time = LocalTime.of(61, 32, 59);
		System.out.println(time.format(DateTimeFormatter.ofPattern("HH-mm-ss")));
		
		
	}

}
