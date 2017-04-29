package com.bitm.newtourstest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.newtourstest.dataprovider.FlightFinderDataProvider;
import com.bitm.newtourstest.utils.DriverManager;
import com.bitm.newtourstest.utils.UrlTextUtils;
import com.bitm.newtourstest.utils.XpathUtils;


public class FlightFinder {
	
	private WebDriver driver = null;
	
	@Test (priority=1)
	public void checkTitle () throws InterruptedException
	{
		driver= DriverManager.driver;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.FlightFinder.INPUT_PASSENGERS)));
		//driver.get(UrlTextUtils.FLIGHT_FINDER_URL);
		//driver.get(UrlTextUtils.FLIGHT_FINDER_TITLE);
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.FLIGHT_FINDER_TITLE);
		
		try{
            throw new Exception();
        } catch(Exception e){
		
		System.out.println("Flight Finder Title Successful");
        }
	}
	
	@Test (priority =2,dataProvider="FlightFinder",dataProviderClass=FlightFinderDataProvider.class)

	public void checkFlightFinder (List<com.bitm.newtourstest.dto.FlightFinder> flightFinders) throws InterruptedException
	{
		for (com.bitm.newtourstest.dto.FlightFinder excelFlightFinder: flightFinders){
			
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_TYPE)).click();;
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_PASSENGERS)).sendKeys(excelFlightFinder.getPassengers());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEAPRTFROM)).sendKeys(excelFlightFinder.getDepartingFrom());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEAPRTONMONTH)).sendKeys(excelFlightFinder.getDepartOnMonth());
			driver.findElement(By.xpath(XpathUtils.FlightFinder.INPUT_DEPARTONDATE)).sendKeys(excelFlightFinder.getDepartONDate());
			
			try{
	            throw new Exception();
	        } catch(Exception e){
			System.out.println("selection complete");
	        }
		}
		
	}
	
	
	
}
