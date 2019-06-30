package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.core.ddf.base.BaseTest3;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestB4 extends BaseTest3
{    
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void testB()
	{
		
		
		
		test = report.startTest("DummyTestB4");
		test.log(LogStatus.INFO, "Starting test testB");
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Broser opening");
		navigate("appurl");
		//Verify signin text
		/*
		 if(!verifyText("signinText_xpath","signinText"))
		 {
			 reportFailure("Text di not match");
		 }
		*/
		
		  softAssert.assertTrue(verifyText("signinText_xpath","signinText"), "Text did not match");
		  softAssert.assertTrue(false, "Error 2");
		  softAssert.assertTrue(true, "Error 3");
		  softAssert.assertTrue(false, "Error 4");
		
		
		//check if mail field is present
		if(!isElementPresent("email_id"))
		{
			reportFailure("Email field not present");
		}
		
		type("email_id", "miraalmamun@gmail.com");
		click("button_xpath");
		verifyTitle();
		test.log(LogStatus.PASS, "TestB successfully executed");
		takeScreenShot();
		
	}
	
	@AfterMethod
	public void quit()
	{   
		
		try
		{
			softAssert.assertAll();
		}
		catch(Error e)
		{
			test.log(LogStatus.FAIL, e.getMessage());
		}
		
		
		
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	
}
