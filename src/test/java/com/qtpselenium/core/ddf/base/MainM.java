package com.qtpselenium.core.ddf.base;

import java.util.Hashtable;

import com.qtpselenium.core.ddf.util.Xls_Reader;

public class MainM 
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
		Hashtable<String, String> table = null;
		Object[][] data = null;
		data = new Object[rows][1];
		for(int row = 0; row < rows; row++)
		{   
			table = new Hashtable<String, String>();
			for(int col = 0; col < columns; col++)
			{
				//System.out.println(xls.getCellData(sheetName, col, dataStartRowNumber+row));
				//System.out.println(xls.getCellData(sheetName, col, colStartRowNumber));
				//System.out.println(xls.getCellData(sheetName, col, dataStartRowNumber+row));
				String key = xls.getCellData(sheetName, col, colStartRowNumber);
				String value = xls.getCellData(sheetName, col, dataStartRowNumber+row);
				//System.out.println(key+" "+value);
				table.put(key, value);
				
			}
			System.out.println(table);
			data[row][0] = table;
		}
		
		System.out.println("==================================");
		for(int rNum = dataStartRowNumber; rNum < dataStartRowNumber+rows;rNum++ )
		{
			for(int cNum = 0; cNum < columns; cNum++)
			{
				System.out.println(xls.getCellData(sheetName, cNum, rNum));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		}
		
		
}


		
		
		
		
		  

