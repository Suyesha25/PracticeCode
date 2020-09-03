package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='deals-shoveler-ns_DHNHE6CF35RG569A2H1X_5647_']/div[2]/div/ul/li")
	private List<WebElement> productList; 
	
	public void selectProduct()
	{
		int listsize = productList.size();
		System.out.println("Number of products present in Today's Deal: "+listsize);
		
	}
	
	public FirstPage(WebDriver dr)
	{
		this.driver= dr;	
		PageFactory.initElements(driver,this);
	}
}
