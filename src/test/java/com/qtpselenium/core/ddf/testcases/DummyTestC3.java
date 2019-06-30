package com.qtpselenium.core.ddf.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest3;
import com.qtpselenium.core.ddf.util.DataUtil;
import com.qtpselenium.core.ddf.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestC3 extends BaseTest3
{    
	
	String testCaseName = "TestC";
	Xls_Reader xls;
    @Test(dataProvider = "getData")
    public void testC(Hashtable<String, String > data)
    {   
    	test = report.startTest("DummyTestC");
    	if(!DataUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equals("N"))
    	{
    		test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
    	}
    	
    	test = report.startTest("DummyTestC2");
    	test.log(LogStatus.INFO,"Starting DummyTestC2" );
    	test.log(LogStatus.FAIL, "Failed DummyTestC2");
    	test.log(LogStatus.INFO, data.toString());
    	//Add an existing screenShot to the testcase.
    	//In the below code a screenShot. I have a picture save to file
    	//C:\\Users\\Mir\\Documents\\ThaqurNote\\ExtentReport\\picimage.png
    	// This picture I am adding to this testC
    	test.log(LogStatus.FAIL, "ScreenShot-->>"+ test.addScreenCapture("C:\\Users\\Mir\\Documents\\ThaqurNote\\ExtentReport\\picimage.png"));
    }
    
    @AfterMethod
    public void quit()
    {
    	report.endTest(test);
    	report.flush();
    }
    
    @DataProvider
	public Object[][] getData()
	{   
		super.init();
		Xls_Reader xls = new Xls_Reader(property.getProperty("xlsPath"));

       return DataUtil.getTestData(xls, testCaseName);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
