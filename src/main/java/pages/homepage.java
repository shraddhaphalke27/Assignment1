package pages;

import java.util.Iterator;


import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class homepage {


	
	
		
			WebDriver driver;
			
			public homepage(WebDriver driver) {
				this.driver = driver;
			}
			public static By SignIn=By.id("nav-link-accountList");
			public static By Search=By.id("twotabsearchtextbox");
			public static By Searchbutton=By.id("nav-search-submit-button");
			public static By Sort=By.xpath("//span[@class='a-dropdown-label' and text()='Sort by:']");
		    By Newest=By.id("s-result-sort-select_4");
		    By Price=By.id("s-result-sort-select_2");
		    public static By All=By.xpath("//span[@class='hm-icon-label' and text()='All']");
		    public static By SignOut=By.xpath("//a[@class='hmenu-item' and text()='Sign Out']");
		    public static By Product=By.xpath("(//img[@class='s-image' ])[1]");
		    public static By AddToCart=By.id("add-to-cart-button");
		    public static By Cart=By.id("nav-cart-count-container");
		    By Filter=By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
		    By Checkout=By.xpath("(//input[@class='a-button-input'])[1]");
		 
		    
		
			
	public void SignIn(){
		driver.findElement(SignIn).click();
	}
	
	public void Sort(){

		driver.findElement(Search).sendKeys("handbags");
		driver.findElement(Searchbutton).click();
		driver.findElement(Sort).click();
		driver.findElement(Newest).click();
	}
	public void Product() {
		
		driver.findElement(Search).sendKeys("watch");
		driver.findElement(Searchbutton).click();
		driver.findElement(Sort).click();
		driver.findElement(Price).click();
		driver.findElement(Product).click();
		
	}
		
		
	
	public void Addtocart() {
		driver.findElement(Search).sendKeys("handbags");
		driver.findElement(Searchbutton).click();
	
		 driver.findElement(Product).click();
			Set<String> ids = driver.getWindowHandles();
		     Iterator<String> it = ids.iterator();
		     String parentId = it.next();    
		     driver.switchTo().window(parentId);
		 String childId = it.next();
	     driver.switchTo().window(childId);
		 driver.findElement(AddToCart).click();
	
		
	}

	public void SignOut() {
	
		driver.findElement(All).click();
		driver.findElement(SignOut).click();
		
	}
	
	public void Cart() {
	driver.findElement(Cart).click();
	}
	
	public void Filter() {
		driver.findElement(Search).sendKeys("Wallet");
		driver.findElement(Searchbutton).click();
		driver.findElement(Product).click();
		driver.findElement(Filter).click();
	}
	
	public void Checkout() {
		driver.findElement(Cart).click();
		driver.findElement(Checkout).click();
	
	}
	}



