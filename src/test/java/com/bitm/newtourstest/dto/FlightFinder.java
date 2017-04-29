package com.bitm.newtourstest.dto;

public class FlightFinder {
	
	private String Passengers;
	private String DepartingFrom;
	private String DepartOnMonth;
	private String DepartONDate;

	public String getPassengers() {
		return Passengers;
	}

	public void setPassengers(String passengers) {
		Passengers = passengers;
	}

	public String getDepartingFrom() {
		return DepartingFrom;
	}

	public void setDepartingFrom(String departingFrom) {
		DepartingFrom = departingFrom;
	}

	public String getDepartOnMonth() {
		return DepartOnMonth;
	}

	public void setDepartOnMonth(String departOnMonth) {
		DepartOnMonth = departOnMonth;
	}

	public String getDepartONDate() {
		return DepartONDate;
	}

	public void setDepartONDate(String departONDate) {
		DepartONDate = departONDate;
	}
	
	public String toString()
	{
		return "FlightFinder [Passengers= "+ Passengers +",DepartingFrom="+ DepartingFrom +", DepartOnMonth = "+ DepartOnMonth +",DepartONDate= "+ DepartONDate +"]";
	}
	
	
	

}
