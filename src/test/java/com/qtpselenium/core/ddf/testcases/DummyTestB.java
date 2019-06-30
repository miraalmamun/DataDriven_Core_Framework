package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest;

public class DummyTestB extends BaseTest
{
	@Test
	public void testB()
	{
		
		openBrowser("Chrome");
		navigate("appurl");
		type("email_xpath", "miraalmamun@gmail.com");
		click("button_xpath");
		verifyTitle();
		reportFail("Title does not match");
		driver.quit();
		
	}

}
