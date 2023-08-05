package com.astroganit.api.payload;

public class DailyHoroscopeAspect {
	
	private String love;
	private String wealth;
	private String family;
	private String carrer;
	private String health;
	private int luckyNumber;
	public DailyHoroscopeAspect() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DailyHoroscopeAspect(String love, String wealth, String family, String carrer, String health,
			int luckyNumber) {
		super();
		this.love = love;
		this.wealth = wealth;
		this.family = family;
		this.carrer = carrer;
		this.health = health;
		this.luckyNumber = luckyNumber;
	}

	
	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}

	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getWealth() {
		return wealth;
	}
	public void setWealth(String wealth) {
		this.wealth = wealth;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getCarrer() {
		return carrer;
	}
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	
	
}
