package Frameworkdesign.FrameworkDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver; //after evrything we got to know we must create a local public WebDriver driver in every class that is calling methods and properties from a base class 
	public Properties pro;
	// here public is used before defining the Webdriver object so that we can call the driver object from other classes too

	public WebDriver ChosingBrowser() throws IOException
	{
		//Properties pro= new Properties();
		pro= new Properties();    // as Properties pro has been defined globally you must remove Properties from here
		//FileInputStream fileName = new FileInputStream("C:\\Users\\ekans\\eclipse-workspace\\FrameworkDemo\\src\\main\\java\\Frameworkdesign\\FrameworkDemo\\data.properties");
		FileInputStream fileName = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Frameworkdesign\\FrameworkDemo\\data.properties\\")	;	
		// now if anyone tries to run this script in their machine they dont need to change the path of machine
		// As now we are providing user.dir
				pro.load(fileName); 
				String browserName= pro.getProperty("browser");
				//String browserName = System.getProperty("browser");  //unComment when try to run through JENKINS
				
				System.out.println(browserName);
				
				//if (browserName=="chrome") failed because  == is operator whereas equals is method in java. == is recommended to compare primitives whereas equals method is recommended to compare the actual content of objects. == can be used with primitives and objects but you can’t use equals method with primitives.
				
				if (browserName.equals("chrome"))
				{
					
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekans\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
					driver=new ChromeDriver();
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return driver;
}
	
	public void ScreenshotPath(String testMethodName, WebDriver driver) throws IOException {
			TakesScreenshot abc = ((TakesScreenshot)driver);
					File xyz = abc.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\screenshot\\"+testMethodName+".png" ;
			FileUtils.copyFile(xyz, new File(destinationFile));
	
		}		

}

