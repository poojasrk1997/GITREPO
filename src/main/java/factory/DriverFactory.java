package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	/*
	 * This method is used to inialize the threadlocal driver on the basis of given browser
	 * @param browser
	 * @retuen this will return tldriver
	 */

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_browser(String browser)
	{
		System.out.println(" broswer value is: " + browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value :  "+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	/*
	*This is used to get the driver with threadlocal
	*
	*/
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

}