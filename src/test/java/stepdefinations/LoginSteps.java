package stepdefinations;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPages;

public class LoginSteps {
	
	private static String title;

	private LoginPages loginPage = new LoginPages(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title Is :" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		System.out.println("Expected title will be: "+expectedTitle);
		System.out.println("Actual title will be: "+ title);
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Forgot your password link should be display")
	public void forgot_your_password_link_should_be_display() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enteruserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

}
