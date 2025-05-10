package com.hiphen.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random ramDom=new Random();
		int ranDomNumber = ramDom.nextInt(5000);
		return ranDomNumber;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dobj);
		return date;
	}
	public static String getRequiredDateYYYYMMDD(int days)
	{

		/*Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dobj);
		
		Calendar cal = sdf.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, days);
		 String reqDate = sdf.format(cal.getTime());
		 return reqDate;
		*/ Date d=new Date();
		   
		   
		   
		   
		   
		  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		  String startdate = sim.format(d);
		 
		  
		  Calendar cal=sim.getCalendar();
		   cal.add(Calendar.DAY_OF_MONTH,30);
		   String enddate = sim.format(cal.getTime());
		 
		   return enddate;
		 
		
		
	}
	
	

}
