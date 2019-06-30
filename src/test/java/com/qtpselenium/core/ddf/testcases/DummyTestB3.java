package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.qtpselenium.core.ddf.base.BaseTest2;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestB3 extends BaseTest2
{    
	
	@Test
	public void testB()
	{
		
		//SoftAssert softassert = new SoftAssert();
		
		test = report.startTest("DummyTestB3");
		test.log(LogStatus.INFO, "Starting test testB");
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Broser opening");
		navigate("appurl");
		//Verify signin text
		 if(!verifyText("signinText_xpath","signinText"))
		 {
			 reportFailure("Text di not match");
		 }
		
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
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
