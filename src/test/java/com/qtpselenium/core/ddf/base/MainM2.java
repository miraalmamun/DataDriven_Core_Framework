package com.qtpselenium.core.ddf.base;

import com.qtpselenium.core.ddf.util.Xls_Reader;

public class MainM2 
{
  public static void main(String[] args)
  {     
	  
	    Xls_Reader xls = new Xls_Reader("C:\\Users\\Mir\\Documents\\ThaqurNote\\Excel\\login.xlsx");
	    String testName = "TestB"; 
	    String sheetName = "Data";
		int testStartRowNumber = 1;
		while(!xls.getCellData(sheetName, 0, testStartRowNumber).equalsIgnoreCase(testName))
		{
			testStartRowNumber++;
		}
		
		int colStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;
		
		int columns = 0;
		while(!xls.getCellData(sheetName, columns, colStartRowNumber).equals(""))
		{
			columns++;
		}
		int rows = 0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNumber+rows).equals(""))
		{
			rows++;
		}
		
		
	
		for(int rNum = dataStartRowNumber; rNum < dataStartRowNumber+rows;rNum++ )
		{
			for(int cNum = 0; cNum < columns; cNum++)
			{
				System.out.println(xls.getCellData(sheetName, cNum, rNum));
			}
		}
	}
		
		
}


		
		
		
		
		  

