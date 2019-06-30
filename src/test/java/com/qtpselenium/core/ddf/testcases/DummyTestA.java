package com.qtpselenium.core.ddf.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest2;

public class DummyTestA extends BaseTest2 
{
	@Test(priority = 1)
	public void testA1()
	{  
		test = report.startTest("DummyTestA");
		Assert.fail();
	}
	
	@Test(priority = 2,dependsOnMethods = "testA1")
	public void testA2()
	{
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"testA1","testA2"} )
	public void testA3()
	{
		
	}

}
