package com.qtpselenium.core.ddf.base;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Ittadi2 
{
   
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
		WebDriver driver;
		driver = new ChromeDriver(ops);
        driver.get("http://www.facebook.com");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("miraalmamunmail.com");
        //After this line I want to take a screenshot. Taking screenshot in Selenium WebDriver
        //We have a predefined interface known as TakesScreenshot(i). This is an interface in Selenium WebDriver
        //So we cannot create an object from it. So what I will do, I will Typecasting it((TakesScreenshot)driver)
        //and I will assign it to the ts variable which is TakesScreenshot type. See the below code(below line)
        //Now this is work as object creation. On ts you can call all predefined methods thats belong to TakesScreenshot interface
        // This line of code>ts.getScreenshotAs(OutputType.FILE)>return File type which is store in 
        //This(getScreenshotAs()) method will asked you how you want this output. "OutputType.FILE"> This will capture the screenshot
        //in term of file. This line(ts.getScreenshotAs(OutputType.FILE)) will take the screenshot and keep it in a memory or buffer
        //
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(source, new File(".\\ScreenShots\\facebook2.png"));
			//The above line copy the srFile and load it to the current directory under ScreenShots Folder. The name of the file is 
			//facebook.png. How to create ScreenShots Folder in the current working directory?
			//Right click on the project>new>Folder>Folder name>ScreenShots>finish
			//source = source file to destination file
			//I will save all screenshot in folder "ScreenShots"
			//The above line take two file arguments
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("ScreenShot taken");
		driver.quit();
	}


}
