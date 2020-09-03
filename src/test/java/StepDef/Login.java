package StepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.Browser;
import Library.ManageExcel;
import Pages.FirstPage;
import Pages.HomePage;
import Pages.SignInEnterEmail;
import Pages.SignInEnterPassword;



public class Login {
	WebDriver driver;
	HomePage homePage;
	SignInEnterEmail enterEmail;
	SignInEnterPassword enterPassword;
	FirstPage FP;
	
	@BeforeMethod
    public void browserLaunch() throws Exception
    {
    	driver= Browser.startBrowser();
    	homePage = new HomePage(driver);
    	enterEmail = new SignInEnterEmail(driver);
    	enterPassword = new SignInEnterPassword(driver); 
    	FP = new FirstPage(driver);
    	
    }
    
	/*@Test(priority=0)
	public void verifyPageTitle()
	{		
		String Title= homePage.getPageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
		
	/*@Test(priority=1)
	public void performLogin() throws Exception
	{		
		enterEmail.clickOnContinue(ManageExcel.getCellData(1, 0));
		enterPassword.clickOnLogin(ManageExcel.getCellData(1, 1));
	} */
	
 	@Test(dataProvider="getLoginData")
	public void performLogin(String Username, String Password) throws Exception
	{
 		homePage.clickOnSignIn();
		enterEmail.clickOnContinue(Username);
		enterPassword.clickOnLogin(Password);
	}
	
	@DataProvider
	public Object[][] getLoginData() throws Exception
	{
		ManageExcel.setExcelFileSheet("LoginData");
		Object data [][]= ManageExcel.getTestData();
		return data;
	} 
	
	/*@Test(priority=3)
	public void selectProductFromTodaysDeal()
	{
	 FP.selectProduct();
	}*/
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
