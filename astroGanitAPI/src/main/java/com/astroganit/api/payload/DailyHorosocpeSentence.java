package com.astroganit.api.payload;

public class DailyHorosocpeSentence {

	private String sentence;

	
	public DailyHorosocpeSentence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DailyHorosocpeSentence(String sentence) {
		super();
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {
		return "DailyHorosocpeSentence [sentence=" + sentence + "]";
	}
	
}
