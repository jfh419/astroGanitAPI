package com.astroganit.api.util;

public class HUtil {

	public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
	public static boolean isInteger(double n) 
	{ 
		return (int)(Math.ceil(n)) == (int)(Math.floor(n)); 
	} 
}
