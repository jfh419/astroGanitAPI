package com.astroganit.api.util;

import java.util.Calendar;

public class DailyHoroUtil {
	//This method is used to return the julian value for specific date 
	//if pass 0 menas today 1 means tomorrow -1 means yesterday
	 public static double getJulianDay(String todate) {
		    
	        double JD=0.0;
	        try {
	        	int dd=Integer.parseInt(todate.substring(0, 2));
	            int mm=Integer.parseInt(todate.substring(2, 4));
	            int yy=Integer.parseInt(todate.substring(4));
	            
	            int A =yy/100;
	            int B = A/4;
	            int C=2-A+B;
	            double E = 365.25 *(yy+4716);
	            double F = 30.6001*(mm);
	            JD = C+dd+E+F-(1524.5);
	        
	        } catch (Exception e) {
	            return JD;
	        }
	        return JD;
	    }
}
