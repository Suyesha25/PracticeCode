package Pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInEnterPassword {
	 WebDriver driver;
		
		@FindBy(xpath="//*[@id='ap_password']")
		private WebElement password;  
		
		@FindBy(xpath="//*[@id='signInSubmit']")
		private WebElement logInButton;  
		
		public void clickOnLogin(String Password)
		{  System.out.println(Password);
			password.sendKeys(Password);
			logInButton.click();
		}
		
		public SignInEnterPassword(WebDriver dr)
		{
			this.driver= dr;	
			PageFactory.initElements(driver,this);
		}
}
