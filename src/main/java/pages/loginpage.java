package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {

	WebDriver driver;
	
	public loginpage(WebDriver driver) {
		this.driver = driver;
}
	public static By Email=By.id("ap_email");
	public static By Continue=By.id("continue");
	public static By Password=By.id("ap_password");
	public static By SignIn=By.id("signInSubmit");


	
public void Action(){
driver.findElement(Email).sendKeys("7420889296");
driver.findElement(Continue).click();
driver.findElement(Password).sendKeys("Phalk@27");
driver.findElement(SignIn).click();
}
}