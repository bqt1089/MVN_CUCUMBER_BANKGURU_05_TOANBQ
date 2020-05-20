package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberConfig.Hooks;
import interfaces.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import actions.PageFactoryManager;
import actions.RegisterPageObject;
import commons.AbstractTest;

public class RegisterSteps {
	WebDriver driver;
	private RegisterPageObject registerPageObject;
	private AbstractTest abstractTest;
	private ShareData shareData;

	public RegisterSteps() {
		driver = Hooks.openBrowser();
		registerPageObject = PageFactoryManager.getRegisterPageDriver(driver);
		shareData = new ShareData();
		abstractTest = new AbstractTest();
	}

	@And("^I get userId and password$")
	public void iGetUserIdAndPassword() {
		ShareData.userId = registerPageObject.getTextElement(driver, RegisterPageUI.NEW_USERID_TEXT);
		ShareData.password = registerPageObject.getTextElement(driver, RegisterPageUI.NEW_PASSWORD_TEXT);
		System.out.println(ShareData.userId);
		System.out.println(ShareData.password);
	}

	@Given("^I open Login page$")
	public void iOpenLoginPage() {
		registerPageObject.openUrl(driver, LoginPageSteps.url);
	}
	
	// INPUT TO EMAIL
		@When("^I input \"([^\"]*)\" into email field$")
		public void iInputSomethingIntoEmailField(String value) {
			value = abstractTest.randomNumber() + value;
			registerPageObject.sendTextToEmailField(value);
		}

}
