package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.Test;

import com.qtpselenium.core.ddf.base.BaseTest;

public class DummyTestA2 extends BaseTest 
{
	@Test(priority = 1)
	public void testA1()
	{  
		
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
