package runner.time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;
import java.util.logging.Logger;

import beginner.methods.time.TimeMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class TimeRunner {

	private static final Logger logger = Logger.getLogger(TimeRunner.class.getName());

	public static void main(String[] args) {
		TimeMethods helperObj = new TimeMethods();
		Scanner scan = new Scanner(System.in);
		String decision;
		do {
			logger.info("Enter the Experiment : ");
			int choice = MyUtil.checkInt(scan);
			try {
			switch (choice) {
			case 1: {
				LocalDateTime time = helperObj.currentTime();
				logger.info("The current time is : " + time);
				break;
			}
			case 2: {
				long milliTime = helperObj.currentTimeMilli();
				logger.info("CurrentTime in milliseconds using LocalDateTime : " + milliTime);
				long systemTime = helperObj.currentSysTimeMilli();
				logger.info("CurrentTime in milliseconds using System : " + systemTime);
				break;
			}
			case 3: {
				logger.info("Enter the continent : ");
				String continent = scan.next();
				logger.info("Enter the country : ");
				String country = scan.next();
				String zoneId = helperObj.convertToZone(continent, country);
				LocalDateTime current = helperObj.customZone(zoneId);
				logger.info("The current date & time in " + zoneId + " : " + current.toString());
				break;
			}
			case 4: {
				DayOfWeek dayNow = helperObj.getCurrentDay();
				logger.info("The day for current time is : " + dayNow);
				
//				logger.info("Enter the year : ");
//				int year = MyUtil.checkInt(scan);
//				logger.info("Enter the month : ");
//				int month = MyUtil.checkInt(scan);
//				logger.info("Enter the date : ");
//				int date = MyUtil.checkInt(scan);
//				logger.info("Enter the hour : ");
//				int hour = MyUtil.checkInt(scan);
//				logger.info("Enter the minute : ");
//				int minute = MyUtil.checkInt(scan);
//				
//				DayOfWeek thatDay = helperObj.getGivenDay(year, month, date, hour, minute);
				logger.info("Enter the time in milli's : ");
				Long milli = scan.nextLong();
				DayOfWeek thatDay = helperObj.getGivenDay(milli);
				logger.info("The day for given data is : " + thatDay);
				break;
			}
			case 5: {
				Month monthNow = helperObj.getCurrentMonth();
				logger.info("The month for current time is : " + monthNow);
				
//				logger.info("Enter the continent : ");
//				String continent = scan.next();
//				logger.info("Enter the country : ");
//				String country = scan.next();
//				String zoneId = helperObj.convertToZone(continent, country);
//				Month givenMonth = helperObj.getGivenMonth(zoneId);
				logger.info("Enter the time in milli's : ");
				Long milli = scan.nextLong();
				Month givenMonth = helperObj.getGivenMonth(milli);
				logger.info("The month for given data is : " + givenMonth);
				break;
			}
			case 6: {
				int yearNow = helperObj.getCurrentYear();
				logger.info("The month for current time is : " + yearNow);
				
//				logger.info("Enter the continent : ");
//				String continent = scan.next();
//				logger.info("Enter the country : ");
//				String country = scan.next();
//				String zoneId = helperObj.convertToZone(continent, country);
//				int givenYear = helperObj.getGivenYear(zoneId);
				logger.info("Enter the time in milli's : ");
				Long milli = scan.nextLong();
				int givenYear = helperObj.getGivenYear(milli);
				logger.info("The month for given data is : " + givenYear);
				break;
			}
			default:
				System.out.println("No matching case.");
			}
			} catch(CustomException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));
	}
}
