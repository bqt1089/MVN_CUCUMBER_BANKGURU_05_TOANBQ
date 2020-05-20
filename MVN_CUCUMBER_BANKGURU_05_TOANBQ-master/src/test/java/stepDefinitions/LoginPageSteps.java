package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;
import actions.LoginPageObject;
import actions.PageFactoryManager;

public class LoginPageSteps{
	WebDriver driver;
	private LoginPageObject loginPageObject;
	public static String url;

	public LoginPageSteps() {
		driver = Hooks.openBrowser();
		loginPageObject = PageFactoryManager.getLoginPageDriver(driver);
		url = driver.getCurrentUrl();
	}

	@Given("^I click Here link button$")
	public void iClickHereLinkButton() {
		loginPageObject.clickRegistHereButton();
	}

	@Then("^I click Login button$")
	public void iClickLoginButton() {
		System.out.println("Register page");
		loginPageObject.clickLoginButton();
	}


}
