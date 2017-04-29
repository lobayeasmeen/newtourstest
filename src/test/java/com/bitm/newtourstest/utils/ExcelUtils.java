package com.bitm.newtourstest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bitm.newtourstest.dto.FlightFinder;
import com.bitm.newtourstest.dto.LogIn;

public class ExcelUtils {

	private static FileInputStream inputstream=null;
	private static Workbook workbook = null;
	
	public static List<LogIn> getLoginData() throws IOException{
		  List<LogIn> logins=new ArrayList<LogIn>();
		  
		  //login is the first sheet in excel so getSheet parameter set to 0
		  Iterator<Row> iterator = ExcelUtils.getSheet(0).iterator();
		        while (iterator.hasNext()) {
		            Row nextRow = iterator.next();
		            Iterator<Cell> cellIterator = nextRow.cellIterator();
		            LogIn excellogin=new LogIn();
		            byte cellCounter=0;
		            while (cellIterator.hasNext()) {
		                Cell cell = cellIterator.next();
		                switch (cellCounter) {
		    case 0:
		     excellogin.setUsername(cell.getStringCellValue());
		     cellCounter++;
		     break;
		    case 1:
		     excellogin.setPassword(cell.getStringCellValue());
		     //cellCounter++;
		     break;
		    default:
		     break;
		    }               
		                 
		            }
//login=sheet name of excel file and keeps data as string into "logins" list pass to .dto.LogIn
		            
		            logins.add(excellogin);
		        }
		        close();
		  return logins;
		}

	public static List<FlightFinder> getFlightFinder() throws IOException
	{
		List<FlightFinder> FlightFinder= new ArrayList<FlightFinder>();
		
	//	DataFormatter 
		DataFormatter formatter = new DataFormatter();
		Iterator<Row> iterator = ExcelUtils.getSheet(1).iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            FlightFinder excelflightfinder=new FlightFinder();
            byte cellCounter=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter) {
    case 0:
     excelflightfinder.setPassengers(formatter.formatCellValue(cell));
     cellCounter++;
     break;
    case 1:
     excelflightfinder.setDepartingFrom(formatter.formatCellValue(cell));
     cellCounter++;
    break;
    case 2:
     excelflightfinder.setDepartOnMonth(formatter.formatCellValue(cell));
     cellCounter++;
    break;
    case 3:
     excelflightfinder.setDepartONDate(formatter.formatCellValue(cell));
    // cellCounter++;
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

	private static Sheet getSheet(int sheetNo) throws IOException {
		
		inputstream = new FileInputStream("I:\\dataproviderfiles\\newtours.xlsx");
		workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = (Sheet) workbook.getSheetAt(sheetNo);
		return sheet;
	}
}
