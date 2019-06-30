package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest2;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestC2 extends BaseTest2
{
    @Test
    public void testC()
    {
    	test = report.startTest("DummyTestC2");
    	test.log(LogStatus.INFO,"Starting DummyTestC2" );
    	test.log(LogStatus.FAIL, "Failed DummyTestC2");
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
