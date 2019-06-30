package com.qtpselenium.core.ddf.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.core.ddf.base.BaseTest3;
import com.qtpselenium.core.ddf.util.DataUtil;
import com.qtpselenium.core.ddf.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestB5 extends BaseTest3
{    
	public SoftAssert softAssert ;
	public String testCaseName = "TestB";
	public Xls_Reader xls;
	@Test(dataProvider = "getData")
	public void testB(Hashtable<String, String> data11)
	{    

		System.out.println(property.getProperty("xlsPath"));
		softAssert = new SoftAssert();
		test = report.startTest("DummyTestB5");
		test.log(LogStatus.INFO, "Starting test testB5");
		test.log(LogStatus.INFO, data11.toString());
		System.out.println("Starting ==============="+data11.toString());
		if(data11.get("Runmode").equals("N"))
		{
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Broser opening");
		navigate("appurl");


		softAssert.assertTrue(verifyText("signinText_xpath","signinText"), "Text did not match");

		softAssert.assertTrue(true, "Error 3");



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

	@BeforeMethod
	public void init()
	{
		softAssert = new SoftAssert();

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

	@DataProvider
	public Object[][] getData()
	{   
		super.init();
		Xls_Reader xls = new Xls_Reader(property.getProperty("xlsPath"));

		return DataUtil.getTestData(xls, testCaseName);
	}


}
