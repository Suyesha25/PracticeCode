package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
static WebDriver driver;
static PropertyValues propVal;
//public static final String testDataExcelFileName = "UserCredentials.xlsx";

public static WebDriver startBrowser()
{   
	propVal= new PropertyValues();
	String browsername= propVal.getValue("browser");
	
	
	if(browsername.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Suyesha/Drivers-Eclips/geckodriver.exe");
		driver=  new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("Chrome"))
	{
//		ChromeOptions options = new ChromeOptions(); 
//		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		System.setProperty("webdriver.chrome.driver", "C://Users//Suyesha/chromedriver.exe");
		driver=  new ChromeDriver();
	}else if(browsername.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Suyesha/chromedriver.exe");
		driver=  new ChromeDriver();
	}
	driver.manage().window().maximize();
	String URL1= propVal.getValue("webURL");
	driver.get(URL1);	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	return driver;
}

public static void closeBrowser()
{
	driver.quit();	
}

}
