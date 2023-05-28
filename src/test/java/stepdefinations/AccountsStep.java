package stepdefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountsPage;
import pages.LoginPages;

public class AccountsStep {
	
	private LoginPages loginPage = new LoginPages(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	private static String title;

	@Given("user is already logeed in to application")
	public void user_is_already_logeed_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
		title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title :" + title);
	}

	@Then("user gets acounts section")
	public void user_gets_acounts_section(DataTable sectionTable) {
		
		List<String> expAccountSectionList = sectionTable.asList();
		System.out.println("Exp account section list"+ expAccountSectionList);
		
		List<String> actualAccountSectionList=accountsPage.getAccountSectionList();
		System.out.println("Actual accoounts section list :"+ actualAccountSectionList);
		
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expcountSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount() == expcountSectionCount);
	}

}
