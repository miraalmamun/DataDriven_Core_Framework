package com.qtpselenium.core.ddf.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public  WebDriver driver;
	public  Properties property;

	public   void openBrowser(String bType)
	{   
		if(property==null)
		{
			property = new Properties();
			try 
			{
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\projectconfig.properties");
				property.load(fs);
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			
		}
		System.out.println(property.getProperty("chromeDriver_exe"));
		if(bType.equalsIgnoreCase("Mozila"))
		{   
          
			System.setProperty("webdriver.gecko.driver", property.getProperty("firefoxDriver_exe"));
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
			System.getProperty("user.dir")+"\\log\\firefox.log");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			/*
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
			System.getProperty("user.dir")+"\\log\\firefox.log");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get("https://cnn.com");
			*/
         }
		else if(bType.equalsIgnoreCase("Chrome"))
		{   System.setProperty("webdriver.chrome.driver", 
			property.getProperty("chromeDriver_exe"));
			ChromeOptions ops = new ChromeOptions();	
			ops.addArguments("--disable-notifications");
			ops.addArguments("disable-infobars");
			ops.addArguments("--start-maximized");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, 
			System.getProperty("user.dir")+"\\log\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver(ops);
			
			
					
		}
		else if(bType.equalsIgnoreCase("IE"))
		{
			
		}
		else if(bType.equalsIgnoreCase("Edge"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}

	public  void navigate(String urlKey)
	{
       driver.get(property.getProperty(urlKey));;
	}

	public void click(String xpathElementKey)
	{
       driver.findElement(By.xpath(property.getProperty(xpathElementKey))).click();
	}

	public void type(String xpathElementKey, String data)
	{
         driver.findElement(By.xpath(property.getProperty(xpathElementKey))).sendKeys(data);;
         
	}


	/*********************************Validations****************************/

	public boolean verifyText()
	{
		return false;
	}


	public boolean verifyTitle()
	{
		return false;
	}

	public boolean isElementPresent()
	{
		return false;
	}

	/*************************Reporting*****************************************************/

	public void reportPass(String ms)
	{

	}

	public void reportFail(String ms)
	{

	}

	public void takeScreenShot()
	{

	}















}
