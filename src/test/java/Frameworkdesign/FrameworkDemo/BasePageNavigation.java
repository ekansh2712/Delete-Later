package Frameworkdesign.FrameworkDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.forgotPassword;
import pageObjects.loginPage;
import pageObjects.loginPage2;

//here extends is used for Inheritance concept of OOPS JAVA, once we extend a class in another class we can use the properties and methods of that class inside the current class
public class BasePageNavigation extends Base{
	public WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException
	{
		driver=ChosingBrowser();
		// calling driver object from another class Base and the method which returns the driver object
		driver.get(pro.getProperty("url"))	;
	
	
	loginPage lp=new loginPage(driver);
	loginPage2 lp2= lp.login(); //tricky and confusing thought of sticking to defining every page object class method
	// upper syntax is className classObjectName = classWhereDefined.MethodWhereDefind()
	//loginPage2 lp2=new loginPage2(driver); we have now defind this in login page class in login method
	lp2.email().sendKeys(Username);
	lp2.password().sendKeys(Password);
	lp2.submit().click();
	forgotPassword fP = lp2.passwordforgot();
		fP.giveEmail().sendKeys("faultywebsite");	
		File xyz = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir")+"\\baseNavigationSS\\"+"SS.png";
		FileUtils.copyFile(xyz, new File (destinationFile));
				
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data= new Object[1][2] ;
				data [0][0] = "itsronjustrockon@gmail.com" ;
				data [0][1]	= "themediocre27" ;
			/*
				data [1][0] = "ekansh.2711@gmail.com" ;
				data [1][1]	= "notsomediocre" ;  
			*/
				return data;
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
}
