package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage2 {
	
	public WebDriver driver;
	
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By submit = By.xpath("//input[@name='commit']");
	By fgtpwd = By.xpath("//a[@class='link-below-button']");
	
	public loginPage2(WebDriver driver)
	{
		this.driver=driver;
	}
			
			  public WebElement email()	{
		return driver.findElement(email);
	}
			
			
			public WebElement password() {
				return driver.findElement(password);
			}

			public WebElement submit() {
				return driver.findElement(submit);
			}
			
			public forgotPassword passwordforgot() {
				driver.findElement(fgtpwd).click();
				forgotPassword fP=new forgotPassword (driver);
				return fP;
			}

		
}
