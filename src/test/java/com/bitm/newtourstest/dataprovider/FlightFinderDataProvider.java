package com.bitm.newtourstest.dataprovider;

import java.io.IOException;

import com.bitm.newtourstest.utils.ExcelUtils;

public class FlightFinderDataProvider {
	
	public static Object [][] getFlightFinderData ()
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
