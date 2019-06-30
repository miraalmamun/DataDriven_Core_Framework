

//Create a package in eclipse
package captureScreenShot;

//Import all classes and interface
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FacebookScreenshot 
{

	//Create Webdriver reference
	WebDriver driver;

	@Test
	public void captureScreenshot() throws Exception
	{

		//Initiate Chrome browser
		//Maximize the browser
		
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
		//Pass application url
		driver.get("http://www.facebook.com");
		//Here we are forcefully passing wrong id so that it will fail our testcase
		driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
		//driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("miraalmamunmail.com");

	}





	//It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result)
	{

		//Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
			try 
			{
				//Create refernce of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot)driver;

				//Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				//Copy files to specific location here it will save all screenshot in our project home directory and
				//result.getName() will return name of test case so that screenshot name will be same
				FileUtils.copyFile(source, new File(".\\ScreenShots\\"+result.getName()+".png"));
				

				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{

				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 



		}
		//close application
		driver.quit();
	}



}

