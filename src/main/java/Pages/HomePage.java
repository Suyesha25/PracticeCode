package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(id="nav-link-accountList")
	private WebElement signInlistBox;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement signInButton;
	
	public void clickOnSignIn()
	{
		
		signInlistBox.click();
	}
			
	public HomePage(WebDriver dr)
	{
		this.driver= dr;	
		PageFactory.initElements(driver,this);
	}
	public String getPageTitle(){
		String pageTitle= driver.getTitle();
		return pageTitle;
	}
	
	

}
