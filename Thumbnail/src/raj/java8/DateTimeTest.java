package raj.java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeTest {

	public static void main(String args[]){
		DateTimeTest dtTest = new DateTimeTest();
		dtTest.testLocalDateTime();
		dtTest.testZonedDateTime();
		dtTest.testChromoUnits();
		dtTest.testPeriod();
		dtTest.testDuration();
		dtTest.testAdjusters();
		dtTest.testBackwardCompatability();
	}


	public void testLocalDateTime(){

		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);

		//12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);

		//22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);

		//parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
	}

	public void testZonedDateTime(){

		// Get the current date and time
		ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Calcutta]");
		System.out.println("date1: " + date1);

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("CurrentZone: " + currentZone);
	}

	public void testChromoUnits(){

		//Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		//add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);

		//add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);

		//add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);

		//add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten year: " + nextDecade);
	}

	public void testPeriod(){

		//Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		//add 1 month to the current date
		LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + date2);

		Period period = Period.between(date2, date1);
		System.out.println("Period: " + period);
	}

	public void testDuration(){
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);

		LocalTime time2 = time1.plus(twoHours);
		Duration duration = Duration.between(time1, time2);

		System.out.println("Duration: " + duration);
	}

	public void testAdjusters(){

		//Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		//get the next tuesday
		LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on : " + nextTuesday);

		//get the second saturday of next month
		LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(), 1);
		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
	}

	public void testBackwardCompatability(){

		//Get the current date
		Date currentDate = new Date();
		System.out.println("Current date: " + currentDate);

		//Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("Local date: " + localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("Zoned date: " + zonedDateTime);
	}
}
