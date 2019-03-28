package com.boot.integration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int s = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(s);
	}
	
	
	private long sum(int a,int b){
		long x = 0L;
		return x;
	}
	
	private long sum(int a,String b){
		int x = 0;
		return x;
	}
}
