package actions;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    public static HomePageObject getHomePageDriver(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPageDriver(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPageDriver(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static EditCustomerPageObject getEditCustomerPageDriver(WebDriver driver) {
        return new EditCustomerPageObject(driver);
    }

    public static NewCustomerPageObject getNewCustomerPageObjectDriver(WebDriver driver) {
        return new NewCustomerPageObject(driver);
    }

    public static NewAccountPageObject getNewAccountPageObject(WebDriver driver) {
        return new NewAccountPageObject(driver);
    }
    
    public static AbstractPageObject getAbstracPageObject(WebDriver driver) {
    	return new AbstractPageObject(driver);
    }

    public static DepositPageObject getDepositPageObject(WebDriver driver) {
        return new DepositPageObject(driver);
    }

    public static WithdrawPageObject getWithdrawPageObject(WebDriver driver) {
        return new WithdrawPageObject(driver);
    }

    public static FundTransferPageObject getFundTransferPageObject(WebDriver driver) {
        return new FundTransferPageObject(driver);
    }

    public static BalanceEquiryPageObject getBalanceEquiryPageObject(WebDriver driver) {
        return new BalanceEquiryPageObject(driver);
    }

    public static DeleteAccountPageObject getDeleteAccountPageObject(WebDriver driver) {
        return new DeleteAccountPageObject(driver);
    }

    public static DeleteCustomerPageObject getDeleteCustomerPageObject(WebDriver driver) {
        return new DeleteCustomerPageObject(driver);
    }

}
