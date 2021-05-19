package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By loginClick =By.cssSelector("a[href*='sign_in']");
	private By gettingTitle = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By headertab = By.xpath("//nav[@class='navbar-collapse collapse']");
	By headertab2 = By.cssSelector("div[class*=\"video-banner\"] p");
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
			
			public loginPage2 login()	{
		driver.findElement(loginClick).click();
		loginPage2 lp2=new loginPage2(driver);
		return lp2;
	}
			public WebElement getTitle() {
				return driver.findElement(gettingTitle);
			}
			
			public WebElement getTab() {
				return driver.findElement(headertab);
			}
			
			public WebElement getTab2() {
				return driver.findElement(headertab2);
			}
			
			
}
