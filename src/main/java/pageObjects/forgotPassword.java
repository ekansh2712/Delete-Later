	package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {
	public WebDriver driver;

	public forgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By Email = By.xpath("//input[@id='user_email']");
	
	public WebElement giveEmail() {
		return driver.findElement(Email);
	}

	
}
