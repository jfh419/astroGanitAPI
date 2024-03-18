package com.astroganit.api.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HUtil {

	public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
	
	public static boolean isInteger(double n) 
	{ 
		return (int)(Math.ceil(n)) == (int)(Math.floor(n)); 
	} 
	public static String getRandomNumberString() {
	    // It will generate 4 digit random Number.
	    // from 1000 to 9999
		Random r = new Random();
	    String randomNumber = String.format("%04d", Integer.valueOf(r.nextInt(9999-1000)+1)+1000);
	    return randomNumber;
	}
	
	public static boolean isValidString(String str) {
		return str != null && !str.trim().isEmpty();
	}
	public static int strToInt(String str) {
		
		int intValue;
		try {
			intValue = Integer.parseInt(str);
		}
		catch (NumberFormatException e) {
			intValue = 1;
		}
		return intValue;
	}
	public static boolean isNullEmpty(String str) {
		String s = Optional.ofNullable(str).orElse("");
		boolean isEmpty=true;
		if (!s.trim().isEmpty()) {
			isEmpty=false;
		}
		return isEmpty;
	}
	
	public static String readFile(String filePath) throws IOException {
		Resource resource = new ClassPathResource(filePath);
		File file = resource.getFile();
		return new String(Files.readAllBytes(file.toPath()));
    }
	
}
