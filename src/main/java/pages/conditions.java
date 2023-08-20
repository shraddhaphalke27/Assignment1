package pages;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import propertiesfile.ReadProperties;
import utilities.Extentmanager;
import utilities.Screenshots;

public class conditions {
	

public static ExtentReports extent;
public static WebDriver driver;
public static ExtentTest test;

public static Actions action;


//@SuppressWarnings("deprecation")
@BeforeSuite


public void setup() 
	{
	
		
		String browserName = ReadProperties.getProperty("browserName");
		System.out.println("Browser name is : "+browserName);
		
		//Set an mode in which the code is supposed to run
		String runOption = ReadProperties.getProperty("RunOption");
		System.out.println("Option for running the program is : " + runOption);
		extent = Extentmanager.getInstance("reports\\ExtentReports.html");
		DOMConfigurator.configure("log4j.xml");
		
		

		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadProperties.getProperty("driver"));
			
			if (runOption.equalsIgnoreCase("headless")) {
				// Create Object of ChromeOption Class
				ChromeOptions options=new ChromeOptions();
				//Set the setHeadless is equal to true which will run test in Headless mode
				options.setHeadless(true);
				driver=new ChromeDriver(options);
				
				
			}
			else {
					driver = new ChromeDriver();

					}
			}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ReadProperties.getProperty("firefoxDriver"));
			if (runOption.equalsIgnoreCase("headless")) {
				// Create Object of FirefoxOption Class
				FirefoxOptions options=new FirefoxOptions();
				//Set the setHeadless is equal to true which will run test in Headless mode
				options.setHeadless(true);
				driver=new FirefoxDriver(options);
				

			}
				else {
					driver = new FirefoxDriver();
				

				}
			}
			
		
		else if (browserName.equalsIgnoreCase("internetexplorer")) {
			System.out.println(ReadProperties.getProperty("‪iedriver"));
			System.setProperty("webdriver.ie.driver", ReadProperties.getProperty("iedriver"));
			
			InternetExplorerOptions capabilites = new InternetExplorerOptions();
			capabilites.ignoreZoomSettings();
			
			
			driver = new InternetExplorerDriver(capabilites);
		}
			
				
		else 
		{
			System.out.println("Invalid browser name");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( Integer. parseInt(ReadProperties.getProperty("GlobalWaitTime"))));

	}



@BeforeMethod
public void beforeMethod(Method method) {
	test = extent.startTest(method.getName());
}

@AfterMethod
public void afterMethod(ITestResult result) {
	
	if(result.getStatus()==ITestResult.SUCCESS)
		test.log(LogStatus.PASS, "Test case got passed");
	else if(result.getStatus()==ITestResult.FAILURE){
		test.log(LogStatus.FAIL, result.getThrowable()); 
		 Screenshots.takeScreenShot(driver,result.getName());
		 }
	else if(result.getStatus()==ITestResult.SKIP)
		test.log(LogStatus.SKIP, result.getThrowable());
	
	extent.flush();
	
}

@AfterSuite
public static void teardown() throws Exception {
	Thread.sleep(3000);
	driver.quit();
	
}
}





