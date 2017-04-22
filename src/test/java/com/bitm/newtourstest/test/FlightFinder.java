package com.bitm.newtourstest.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bitm.newtourstest.utils.DriverManager;
import com.bitm.newtourstest.utils.UrlFlightFinder;

public class FlightFinder {
	
	private WebDriver driver = null;
	
	public void checkTitle () throws InterruptedException
	{
		driver= DriverManager.driver;
		driver.get(UrlFlightFinder.FLIGHTFINDER_URL);
		driver.get(UrlFlightFinder.FLIGHTFINDER_TITLE);
		Assert.assertEquals(driver.getTitle(), UrlFlightFinder.FLIGHTFINDER_TITLE);
		System.out.println("Flight Finder Title Successful");
	}
	
	public void checkFlightFinder (List<com.bitm.newtourstest.dto.FlightFinder> flightFinders)
	{
		
		
	}
	
}
