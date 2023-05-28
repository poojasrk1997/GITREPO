package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {

	private WebDriver driver;

	// By locators :Object repository

	private By emailid = By.id("email");
	private By Password = By.id("passwd");
	private By login = By.id("SubmitLogin");
	private By ForgotPwdLink = By.linkText("Forgot your password?");

	// Constructor of page class:

	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Action Methods
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(ForgotPwdLink).isDisplayed();
	}

	public void enteruserName(String username)
	{
		driver.findElement(emailid).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(login).click();
	}
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println("Login with :"+ un +"and"+pwd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(login).click();
		return new AccountsPage(driver);
	}
}
