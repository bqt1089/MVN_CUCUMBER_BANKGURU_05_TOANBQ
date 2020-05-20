package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;
import interfaces.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public RegisterPageObject clickRegistHereButton() {
		waitForControlVisible(driver, LoginPageUI.HERE_BUTTON);
		clickElementByJS(driver, LoginPageUI.HERE_BUTTON);
		return PageFactoryManager.getRegisterPageDriver(driver);
	}

	public HomePageObject clickLoginButton() {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX,LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePageDriver(driver);
	}
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
}
