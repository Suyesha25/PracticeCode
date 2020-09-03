package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInEnterEmail {
    WebDriver driver;
	
	@FindBy(xpath="//*[@id='ap_email']")
	private WebElement email;  
	
	@FindBy(xpath="//*[@id='continue']")
	private WebElement continueButton;  
	
	public void clickOnContinue(String Username)
	{ System.out.println(Username);
		email.sendKeys(Username);
		continueButton.click();
	}
	
	public SignInEnterEmail(WebDriver dr)
	{
		this.driver= dr;	
		PageFactory.initElements(driver,this);
	}
}
