package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
    public static void capureScreenShot(WebDriver driver,String screenShotName)
    {
    	
    	try 
    	{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(".\\ScreenShots\\"+screenShotName+".png"));
			System.out.println("ScreenShot taken");
		} 
    	catch (Exception e) 
    	{
			System.out.println("Exception while taking screenshot"+e.getMessage());
			e.printStackTrace();
		} 
    	
	}

    	
    }

