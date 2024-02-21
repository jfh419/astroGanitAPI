package com.astroganit.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendSMS {

	@Value("${OTPKEY}")
    private String OTPKEY;
	
	@Value("${OTPMSG}")
    private String OTPMSG;
	
	@Value("${OTPSENDER}")
    private String OTPSENDER;

	public String sendSms(String mobile,String otp) {
		try {
			// Construct data
			String apiKey = "apikey=" + this.OTPKEY;
			String message = "&message=" +otp+" "+this.OTPMSG;
			String sender = "&sender=" + this.OTPSENDER;
			String numbers = "&numbers=" + mobile;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
