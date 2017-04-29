package com.bitm.newtourstest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bitm.newtourstest.utils.ExcelUtils;

public class FlightFinderDataProvider {
	
	@DataProvider (name="FlightFinder")
	public static Object [][] getFlightFinderData ()
	{
		try {
			   return new Object[][]{
			     {
			      ExcelUtils.getFlightFinder()
			     },
			    };
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			   return null;
			  }
	}
}
