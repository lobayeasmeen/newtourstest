package com.bitm.newtourstest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bitm.newtourstest.dto.FlightFinder;

public class ExcelUtilFlightFind {
	private static FileInputStream inputstream = null;
	private static Workbook workbook = null;

	public static List<FlightFinder> getFlightFinder() throws IOException
	{
		List<FlightFinder> FlightFinder= new ArrayList<FlightFinder>();
		
	//	DataFormatter 
		Iterator<Row> iterator = ExcelUtilFlightFind.getSheet(1).iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            FlightFinder excelflightfinder=new FlightFinder();
            byte cellCounter=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter) {
    case 0:
     excelflightfinder.setPassengers(cell.getStringCellValue());
     cellCounter++;
     break;
    case 1:
     excelflightfinder.setDepartingFrom(cell.getStringCellValue());
     cellCounter++;
    break;
    
    case 2:
     excelflightfinder.setDepartOnMonth(cell.getStringCellValue());
     cellCounter++;
    break;
    case 3:
     excelflightfinder.setDepartONDate(cell.getStringCellValue());
     cellCounter++;
    break;
    default:
    	break;
	}
            }
            FlightFinder.add(excelflightfinder);
        }
        close();
        return FlightFinder;
	}
	
	private static void close() throws IOException {
		
		workbook.close();
		inputstream.close();
	}
	
	private static Sheet getSheet (int sheetno) throws IOException
	{
		inputstream=new FileInputStream("I:\\dataproviderfiles\\newtours.xlsx");
		workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = (Sheet) workbook.getSheetAt(sheetno);
		return sheet;
	}
	
}
