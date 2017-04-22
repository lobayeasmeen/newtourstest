package com.bitm.newtourstest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bitm.newtourstest.utils.DriverManager;
import com.bitm.newtourstest.utils.XpathUtils;

public class FlightFinder {
	
	private WebDriver driver = null;
	
	public void checkTitle () throws InterruptedException
	{
		driver= DriverManager.driver;
		driver.get(com.bitm.newtourstest.utils.UrlTextUtils.UrlFlightFinder.FLIGHT_FINDER_URL);
		driver.get(com.bitm.newtourstest.utils.UrlTextUtils.UrlFlightFinder.FLIGHT_FINDER_TITLE);
		Assert.assertEquals(driver.getTitle(), com.bitm.newtourstest.utils.UrlTextUtils.UrlFlightFinder.FLIGHT_FINDER_TITLE);
		System.out.println("Flight Finder Title Successful");
	}
	
	

	public void checkFlightFinder (List<com.bitm.newtourstest.dto.FlightFinder> flightFinders) throws InterruptedException
	{
		for (com.bitm.newtourstest.dto.FlightFinder excelFlightFinder: flightFinders){
			
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_TYPE)).submit();
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_PASSENGERS)).sendKeys(excelFlightFinder.getPassengers());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEAPRTFROM)).sendKeys(excelFlightFinder.getDepartingFrom());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEAPRTONMONTH)).sendKeys(excelFlightFinder.getDepartOnMonth());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEPARTONDATE)).sendKeys(excelFlightFinder.getDepartONDate());
			System.out.println("selection complete");
		}
		
	}
	
	
	
}
