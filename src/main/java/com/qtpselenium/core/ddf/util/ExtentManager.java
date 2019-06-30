package com.qtpselenium.core.ddf.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager
{
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() 
	{
		if (extent == null) 
		{   
			
			//extent = new ExtentReports(".\\report.html", true, DisplayOrder.NEWEST_FIRST);
			
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(".\\Report\\ExtentReports"+fileName, true, DisplayOrder.NEWEST_FIRST);
			
			////This is the file(above line) where ExtentReports will be save.
			
			
            //optional
			//extent.config().documentTitle("Automation Report").reportName("Regression").reportHeadline("");
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			//This is the line(above ) bridge between ExtentManager class and ReportsConfig.xml
			
			// optional
			extent.addSystemInfo("Selenium Version", "2.52.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
