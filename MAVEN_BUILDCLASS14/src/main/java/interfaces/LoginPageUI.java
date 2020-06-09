package interfaces;

public class LoginPageUI {
    public static final String URL = "https://wordpress.com/admin";
    public static final String USERNAME_TXB = "//input[@id='usernameOrEmail']";
    public static final String CONTINUE_BTN = "//button[@class='button form-button is-primary']";
    public static final String ERROR_EMAIL_TXT = "//div[@class='form-input-validation is-error']//span";
    public static final String ERROR_DOES_NOT_EXIST = "User does not exist. Would you like to create a new account?";
    public static final String ERROR_FORMAT_WP = "Please log in using your WordPress.com username instead of your email address.";
    public static final String ERROR_EMPTY_EMAIL = "Please enter a username or email address.";

}
