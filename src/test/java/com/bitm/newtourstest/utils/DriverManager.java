package com.bitm.newtourstest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	
	
	static {
		
		System.setProperty("webdriver.gecko.driver", "F://Selenium test environment/geckodriver-v0.15.0-win32/geckodriver.exe");
	}
	public static WebDriver driver = new FirefoxDriver ();
	
//	public static WebDriver driver = new ChromeDriver();
	
	private DriverManager() {
	
	}
	
}
	

