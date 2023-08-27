package com.globalin.biz.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
	
		private static SimpleDateFormat formatter;
		private static Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		public DateUtil() {
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			formatter.format(currentTime);
		}
		
		
		public static Timestamp getCurrentTime() {
			return currentTime;
		}
	
}
