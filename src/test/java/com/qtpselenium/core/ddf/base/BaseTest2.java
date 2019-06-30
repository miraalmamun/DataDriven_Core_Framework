package com.qtpselenium.core.ddf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.qtpselenium.core.ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;


public class BaseTest2 
{
	public static WebDriver driver;
	public static Properties property;
	public ExtentReports report = ExtentManager.getInstance();
	public ExtentTest test;

	public   void openBrowser(String bType)
	{   
		if(property==null)
		{
			property = new Properties();
			try 
			{
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\projectconfig2.properties");
				property.load(fs);
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			
		}
		//System.out.println(property.getProperty("chromeDriver_exe"));
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

	public void click(String locatorKey)
	{
       getElement(locatorKey).click();
	}

	public void type(String locatorKey, String data)
	{
         getElement(locatorKey).sendKeys(data);;
         
	}
	
	public WebElement getElement(String locatorKey)
	{   
		
		/*This method finds elements and return it*/
		/*Finding elements and returning it*/
		/*Fail the test and report the error. Any time anything can happen Test can failed for programmer
		 * error and element not found on web page or giver locator wrong for this reason we need to take it 
		 * inside try catch blook */
		WebElement e = null;
	 try
	   {
			if(locatorKey.endsWith("_id"))
			{
				e = driver.findElement(By.id(property.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_name"))
			{
				e = driver.findElement(By.name(property.getProperty(locatorKey)));
			}
			else if(locatorKey.endsWith("_xpath"))
			{
				e = driver.findElement(By.xpath(property.getProperty(locatorKey)));
			}
			else
			{
				reportFailure("locator not correct :" + locatorKey);
				Assert.fail("locator not correct :" + locatorKey);
			}
	   }	
		catch(Exception ex)
	       {
			reportFailure(ex.getMessage());
			ex.getStackTrace();
			System.out.println("===========================================================================");
			Assert.fail("Failed the test because of : "+ex.getMessage());
	       }
			return e;
		
			
	}


	/*********************************Validations****************************/



	public boolean verifyTitle()
	{
		return false;
	}

	public boolean isElementPresent(String locatorKey){
		List<WebElement> elementList=null;
		if(locatorKey.endsWith("_id"))
			elementList = driver.findElements(By.id(property.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			elementList = driver.findElements(By.name(property.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			elementList = driver.findElements(By.xpath(property.getProperty(locatorKey)));
		else{
			reportFailure("Locator not correct - " + locatorKey);
			Assert.fail("Locator not correct - " + locatorKey);
		}
		
		if(elementList.size()==0)
			return false;	
		else
			return true;
	}
	
	public boolean verifyText(String locatorKey,String expectedTextKey)
	{
		String actualText=getElement(locatorKey).getText().trim();
		String expectedText=property.getProperty(expectedTextKey);
		if(actualText.equals(expectedText))
			return true;
		else 
			return false;
	}

	/*************************Reporting*****************************************************/

	public void reportPass(String msg)
	{
        test.log(LogStatus.PASS, msg);
	}

	public void reportFailure(String msg)
	{
          test.log(LogStatus.FAIL, msg);
          takeScreenShot();
          Assert.fail(msg);
	}


	public void takeScreenShot()
	{
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotFile));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//put screenshot file in reports
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotFile));
		

	}













}
