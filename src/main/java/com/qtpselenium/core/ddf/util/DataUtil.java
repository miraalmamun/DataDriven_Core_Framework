package com.qtpselenium.core.ddf.util;

import java.util.Hashtable;

//import com.reading.Xls_Reader;

public class DataUtil {

	public static Object[][] getTestData(Xls_Reader xls, String testName) {

		// Xls_Reader xls = new
		// Xls_Reader("C:\\Users\\Mir\\Documents\\ThaqurNote\\Excel\\login.xlsx");

		Object data[][] = null;
		Hashtable<String, String> table = null;

		String sheetName = "Data";

		int testStartRowNum = 0;
		while (!xls.getCellData(sheetName, 0, testStartRowNum).equalsIgnoreCase(testName)) {
			testStartRowNum++;
		}
		System.out.println("Test starts from row: " + testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		int rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("Total data rows in the test: " + rows);

		int columns = 0;
		while (!xls.getCellData(sheetName, columns, colStartRowNum).equals("")) {
			columns++;
		}
		System.out.println("Total data columns in the test: " + columns);

		System.out.println("Data start row number: " + dataStartRowNum);
		data = new Object[rows][1];

		for (int row = 0; row < rows; row++) {
			table = new Hashtable<String, String>();
			for (int col = 0; col < columns; col++) {
				// System.out.println(xls.getCellData(sheetName, col, dataStartRowsNum+row));
				String key = xls.getCellData(sheetName, col, colStartRowNum);
				String value = xls.getCellData(sheetName, col, dataStartRowNum + row);
				table.put(key, value);

			}
			data[row][0] = table;
			// System.out.println("key and value: "+table);
		}

		return data;

	}

	public static boolean isRunnable(String TestName, Xls_Reader xl) {
		String sheet = "TestCases";
		int rows = xl.getRowCount(sheet);
		for (int row = 2; row < rows; row++) {
			if (xl.getCellData(sheet, "TCID", row).equals(TestName)) {
				if (xl.getCellData(sheet, "Runmodes", row).equals("Y"))
					return true;
				else
					return false;

			}

		}
		return false;
	}

}
