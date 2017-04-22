package com.bitm.newtourstest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.newtourstest.dataprovider.LogInDataProvider;
import com.bitm.newtourstest.dto.LogIn;
import com.bitm.newtourstest.utils.DriverManager;
import com.bitm.newtourstest.utils.UrlTextUtils;
import com.bitm.newtourstest.utils.XpathUtils;

public class LogInTest {
	
	private WebDriver driver = null;
	
	@Test (priority =1)
	public void checkTitle () throws InterruptedException
	
	{
	//	driver = DriverManager.driver;
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.BASE_URL);
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.LOGIN_PAGE_TITLE);
		System.out.println("Title Successful!!!");
		
	}
	
	@Test (priority =2,dataProvider="loginData",dataProviderClass=LogInDataProvider.class)
	
	public void checkLogin (List<LogIn> logIns) throws InterruptedException
	{
	for (LogIn excellogin: logIns) {
		
		driver.findElement(By.xpath(XpathUtils.LogIn.INPUT_USER_NAME)).sendKeys(excellogin.getUsername());
		driver.findElement(By.xpath(XpathUtils.LogIn.INPUT_USER_PASS)).sendKeys(excellogin.getPassword());
		driver.findElement(By.xpath(XpathUtils.LogIn.BUTTON_SIGNIN)).submit();
		System.out.println("Login Successful!!!");
	}
	
	}
}
