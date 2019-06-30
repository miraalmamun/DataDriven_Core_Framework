package com.qtpselenium.core.ddf.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Utility;

public class Ittadi4 
{
    
	
	WebDriver driver;
	@Test


	public void captureScreenShot()
	{   
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();	
		ops.addArguments("--disable-notifications");
		ops.addArguments("disable-infobars");
		ops.addArguments("--start-maximized");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, 
				System.getProperty("user.dir")+"\\log\\chrome.log");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		driver = new ChromeDriver(ops);
		
        driver.get("http://www.facebook.com");
        Utility.capureScreenShot(driver, "BrowseStarted");
        driver.findElement(By.xpath("//*[@id=\"emailaaaa\"]")).sendKeys("miraalmamunmail.com");
        
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.capureScreenShot(driver, result.getName());
		}
		driver.quit();
		
		
	}

	
	
}
