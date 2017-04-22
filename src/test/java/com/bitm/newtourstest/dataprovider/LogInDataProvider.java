package com.bitm.newtourstest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bitm.newtourstest.utils.ExcelUtils;

public class LogInDataProvider {
	
	@DataProvider(name="loginData")
	public static Object [][] getLogInData()
	{
		try {
			   return new Object[][]{
			     {
			      ExcelUtils.getLoginData()
			     },
			    };
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			   return null;
			  }      
		
	}

}
