package com.about.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @author xiaolong
 */

public class TestTime {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
//		test1();
//		test2();
		test3();
	}

	private static void test1() {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		
//		String format = sdf.format(now);
		String format = sdf.format(date);
		System.out.println(format);
		
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTime());
	}

	private static void test2() throws ParseException { //String与Date互转
		// Data转String
		Date d1 = new Date(System.currentTimeMillis());
		System.out.println(sdf.format(d1));
		// String转Date
		String date = "2015-04-21";
		System.out.println(sdf.parse(date).toString());
		
	}

	private static void test3() throws ParseException { //好友生日提醒(2周前的某个周六)
		String birthday = "2015-06-04";
		Date parse = sdf.parse(birthday);
		
		Date spec = prepareBirthdayDay(parse);
		
		System.out.println(sdf.format(spec));
	}

	private static Date prepareBirthdayDay(Date parse) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(parse);
		cl.set(Calendar.WEEK_OF_MONTH, -2);
		cl.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		return cl.getTime();
	}
}
