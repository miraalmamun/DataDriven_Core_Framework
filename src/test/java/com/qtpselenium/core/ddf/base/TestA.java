package com.qtpselenium.core.ddf.base;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.util.Xls_Reader;

public class TestA 
{
    @Test(dataProvider = "getData")
    public void testA(Hashtable<String, String> table1)
    {
    	System.out.println(table1.get("Runmode"));
    }
    
    @DataProvider
    public Object[][] getData()
    {
    	
    	
        
  	  
  	    Xls_Reader xls = new Xls_Reader("C:\\Users\\Mir\\Documents\\ThaqurNote\\Excel\\login.xlsx");
  	    String testName = "TestA"; 
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
  		
  		  Object[][] data = new Object[rows][1];
  		  Hashtable<String, String> table = null;
  	    int rNumber = 0;
  		for(int rNum = dataStartRowNumber; rNum < dataStartRowNumber+rows;rNum++ )
  		{    
  			table = new Hashtable<String, String>();
  			for(int cNum = 0; cNum < columns; cNum++)
  			{   
  				String key = xls.getCellData(sheetName, cNum, colStartRowNumber);
  				String value = xls.getCellData(sheetName, cNum, rNum);
  				table.put(key, value);
  			}
  			data[rNumber][0]=table;
  			rNumber++;
  		}
  	 return data;
    }
}
