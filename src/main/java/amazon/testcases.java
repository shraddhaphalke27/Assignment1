package amazon;

import java.io.IOException;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import logger.log;
import pages.conditions;
import pages.homepage;
import pages.loginpage;
import propertiesfile.ReadProperties;

public class testcases extends conditions{

	
//TestCase 1 for Signing In and Signing Out
	@Test(priority=1)
	public void Testcase1(){
		driver.get(ReadProperties.getProperty("url"));
		homepage hp= new homepage(driver);
		loginpage lp=new loginpage(driver);
		hp.SignIn();
		lp.Action();
		hp.SignOut();
		log.info("Testcase 1 Signed In and Signed Out Successfully");
	}
	
//TestCase 2 for Sorting
	@Test(priority=2)
	public void Testcase2(){
	driver.get(ReadProperties.getProperty("url"));
	homepage hp= new homepage(driver);
	hp.Sort();
	log.info("Testcase 2 Sorting Functionality Completed");
	
	}
	
//TestCase 3 for selecting Product
	@Test(priority=3)
	public void Testcase3(){
	driver.get(ReadProperties.getProperty("url"));
	homepage hp= new homepage(driver);
	hp.Product();
	log.info("Testcase 3 Product is selected");
		}
	
//TestCase 4 for Adding product to Cart
	@Test(priority=4)
	public void Testcase4(){
	driver.get(ReadProperties.getProperty("url"));
	homepage hp= new homepage(driver);
	 
	hp.Addtocart();
	log.info("Testcase 4 Product is added to cart");
		}	
	
	//TestCase 5 for Applying Filter 
		@Test(priority=5)
		public void Testcase5(){
		driver.get(ReadProperties.getProperty("url"));
		homepage hp= new homepage(driver);
		 
		hp.Filter();
		log.info("Testcase 5 Filter Functionality Completed");
			}	
		
		//TestCase 6 for Checking out product from Cart
		@Test(priority=6)
		public void Testcase6(){
		driver.get(ReadProperties.getProperty("url"));
		homepage hp= new homepage(driver);
		 
		hp.Checkout();
		log.info("Testcase 6 Product is proceeded to checkout from cart");
			}	
		
		
	
//Test Case 7 to check visibility of Sign In Button
	@Test(priority=7)
	public static void Testcase7() {
		
		// navigating to website
		driver.get(ReadProperties.getProperty("url"));
		
		boolean isDisplayed= driver.findElement(homepage.SignIn).isDisplayed();
		if(isDisplayed) { 
			System.out.println("Test Case 7: Button is Displayed " + Thread.currentThread().getId());
		}
		
		else {
			System.out.println("Test Case 7: Button is not Displayed" + Thread.currentThread().getId());
			}
		log.info("Testcase 7 sign In button is visible");
	}
	
	//TestCase 8 to check whether the Sign In Button is enabled 
	@Test(priority=8)
	public static void Testcase8()
	{
		// navigating to website
		driver.get(ReadProperties.getProperty("url"));
		boolean isEnabled= driver.findElement(homepage.SignIn).isEnabled();
		
		
		if(isEnabled) { 
			System.out.println("Test Case 8: Button is Enabled " + Thread.currentThread().getId());
		}
		
		else {
			System.out.println("Test Case 8: Button is not Enabled " + Thread.currentThread().getId());
			}
		log.info("Testcase 8 sign In button is enabled");
	}
	
	//TestCase 9 to check visibility of the email text field 
	@Test(priority=9)
	public static void Testcase9() {
		driver.get(ReadProperties.getProperty("url"));
		// sending the function on which it is to be clicked
		driver.findElement(homepage.SignIn).click();
		boolean isDisplayed= driver.findElement(loginpage.Email).isDisplayed();
		if(isDisplayed) { 
			System.out.println("Test Case 9 : Email text field is Displayed " + Thread.currentThread().getId());
		}
		
		else {
			System.out.println("Test Case 9 : Email text field is not Displayed " + Thread.currentThread().getId());
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		log.info("Testcase 9 Email text field is visible");
	}
		
	//TestCase 10 to check visibility of the password text field
	@Test(priority=10)
	public static void Testcase10() {
		
		driver.get(ReadProperties.getProperty("url"));
		driver.findElement(homepage.SignIn).click();
		
		// sending the request to enter the email in email text field
		driver.findElement(loginpage.Email).sendKeys(ReadProperties.getProperty("validEmailId"));
		
		//sending the function on which it is to be clicked
		driver.findElement(loginpage.Continue).click();
		
		//Checking visibility of password text field
		boolean isDisplayed= driver.findElement(loginpage.Password).isDisplayed();
		if(isDisplayed) { 
			
			System.out.println("Test Case 10: Button is Displayed " + Thread.currentThread().getId());
		}
		
		else {
			System.out.println("Test Case 10: Button is not Displayed " + Thread.currentThread().getId());
			}
		log.info("Testcase 10 Password text field is visible");
	
	}



	
		
	

public static void main(String[] args)throws InterruptedException, IOException  {
// TODO Auto-generated method stub
testcases tc = new testcases();
tc.Testcase1();
tc.Testcase2();
tc.Testcase3();
tc.Testcase4();

}

}





