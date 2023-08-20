package amazon;

import org.testng.Assert;
import logger.log;
import org.testng.annotations.Test;



import pages.conditions;
import pages.homepage;
import pages.loginpage;
import propertiesfile.ReadProperties;

public class failingtestcases extends conditions {
	//Check Whether user gets redirected to password page after the enter of invalid email ID
		@Test(priority=1)
		public static void TestCase11() {
				
			
			System.out.println("Test Case 11: Failed " + Thread.currentThread().getId());
			
			//Adding Assertions 
			String ExpectedTitle = "Amazon Sign In";
				// navigating to website
				driver.get(ReadProperties.getProperty("url"));
				

				// sending the function on which it is to be clicked
				driver.findElement(homepage.SignIn).click();
						
				// sending the request to enter the email in email text field
				driver.findElement(loginpage.Email).sendKeys(ReadProperties.getProperty("invalidEmailId"));
				
				//sending the function on which it is to be clicked
				driver.findElement(loginpage.Continue).click();
				
				log.info("Testcase 11 Invalid Email Id");
				
				// sending the request to enter the password in password text field
				driver.findElement(loginpage.Password).sendKeys(ReadProperties.getProperty("validPassword"));
				
				//sending the function on which it is to be clicked ( In this case: Login Button after password is entered )
				driver.findElement(loginpage.SignIn).click();
				
				//sending the function of options menu to click for signout
				driver.findElement(homepage.All).click();
				
				driver.findElement(homepage.SignOut).click();
				
				String ActualTitle = driver.getTitle();
				System.out.println("The title of the application is : "+ ActualTitle);
				Assert.assertEquals(ActualTitle, ExpectedTitle);
				
				
				

				}
		//Check Whether product is displayed in cart after clicking on the product 
		@Test(priority=2)
		public static void TestCase12() {
				
			
			System.out.println("Test Case 12 : Failed" + Thread.currentThread().getId());
			
		
				driver.get(ReadProperties.getProperty("url"));
				
				driver.findElement(homepage.Search).sendKeys(ReadProperties.getProperty("Product_name"));
				
				driver.findElement(homepage.Searchbutton).click();
				
				driver.findElement(homepage.Sort).click();
				
				driver.findElement(homepage.Product).click();
				
				driver.findElement(homepage.Cart).click();
				
				log.info(" Testcase 12 Product is not displayed in cart");
				
				driver.findElement(homepage.Product).isDisplayed();
				
			
				
				
		}
}
