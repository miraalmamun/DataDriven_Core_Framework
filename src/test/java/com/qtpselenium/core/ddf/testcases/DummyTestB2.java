package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest2;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestB2 extends BaseTest2
{    
	
	@Test
	public void testB()
	{
		
		test = report.startTest("DummyTestB2");
		test.log(LogStatus.INFO, "Starting test testB");
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Broser opening");
		navigate("appurl");
		//check if mail field is present
		reportFailure("Email field not present");
		type("email_id", "miraalmamun@gmail.com");
		click("button_xpath");
		verifyTitle();
		test.log(LogStatus.PASS, "TestB successfully executed");
		takeScreenShot();
		
	}
	
	@AfterMethod
	public void quit()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
