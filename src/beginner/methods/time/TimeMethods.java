package beginner.methods.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import myutil.CustomException;
import myutil.MyUtil;

public class TimeMethods {

	public LocalDateTime currentTime() {
		return LocalDateTime.now();
	}
	
	public long currentTimeMilli() {
		long milli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		return milli;
	}
	
	public long currentSysTimeMilli() {
		long milli = System.currentTimeMillis();
		return milli;
	}
	
	public String convertToZone(String continent, String local) {
		return continent.concat("/").concat(local);
	}
	
	public LocalDateTime customZone(String input) throws CustomException {
		MyUtil.checkTimeZone(input);
		ZoneId place = ZoneId.of(input);
		return LocalDateTime.now(place);
	}
	
	public DayOfWeek getCurrentDay() {
		return LocalDateTime.now().getDayOfWeek();
	}
	
//	public DayOfWeek getGivenDay(int year, int month, int date, int hour, int minute) {
//		return LocalDateTime.of(year, month, date, hour, minute).getDayOfWeek();
//	}
	
	public DayOfWeek getGivenDay(Long milli) {
		return LocalDate.ofEpochDay(milli).getDayOfWeek();
	}
	
	public Month getCurrentMonth() {
		return LocalDateTime.now().getMonth();
	}
	
//	public Month getGivenMonth(String input) throws CustomException {
//		MyUtil.checkTimeZone(input);
//		ZoneId place = ZoneId.of(input);
//		return LocalDateTime.now(place).getMonth();
//	}
	
	public Month getGivenMonth(Long milli) {
		return LocalDate.ofEpochDay(milli).getMonth();
	}
	
	public int getCurrentYear() {
		return LocalDateTime.now().getYear();
	}
	
//	public int getGivenYear(String input) throws CustomException {
//		MyUtil.checkTimeZone(input);
//		ZoneId place = ZoneId.of(input);
//		return LocalDateTime.now(place).getYear();
//	}
	
	public int getGivenYear(Long milli) {
		return LocalDate.ofEpochDay(milli).getYear();
	}
	
}
