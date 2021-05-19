package Frameworkdesign.FrameworkDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;


//here extends is used for Inheritance concept of OOPS JAVA, once we extend a class in another class we can use the properties and methods of that class inside the current class
public class validatingTitle extends Base{
	public WebDriver driver;    //this is must as we are calling this class inside a listener class, written in base class too
	loginPage lp;
	@Test
	public void validateTitle() throws IOException
	{
		driver=ChosingBrowser();
		// calling driver object from another class Base and the method which returns the driver object
			driver.get(pro.getProperty("url"))	;
			driver.manage().window().maximize();
			lp=new loginPage(driver);
	
	Assert.assertTrue(lp.getTab().isDisplayed());
	
	
	Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
	System.out.println("Assert Succesful");
		}
	@Test
	public void validateTitle2() {
		Assert.assertTrue(lp.getTab2().isDisplayed());
		
		
		Assert.assertEquals(lp.getTab2().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		System.out.println("Assert Succesful again");
		}
	
	
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
