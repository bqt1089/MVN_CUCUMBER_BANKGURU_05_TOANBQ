package interfaces;

public class AbstractPageUI {
	public class DynamicLocator {
		public static final String DYNAMIC_XPATH_OPENPAGE = "//a[text()='%s']";
		public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
		public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
		public static final String DYNAMIC_RADIO_BUTTON = "//input[@type='radio' and @value='%s']";
		public static final String DYNAMIC_DETAIL_TABLE = "//td[text()='%s']/following-sibling::td";
		public static final String DYNAMIC_ERROR_MESS = "//label[@id='%s']";
		public static final String SUCCESS_TEXT_ON_TABLE = "//p[@class='heading3']";
		public static final String DYNAMIC_SELECT_DROPDOWN = "//select[@name='%s']";

	}

	public class FieldName {
		public static final String CUSTOMER_NAME_FIELD = "name";
		public static final String CUSTOMER_RADIO_MALE = "m";
		public static final String CUSTOMER_RADIO_FEMALE = "f";
		public static final String DATE_OF_BIRTH_FIELD = "dob";
		public static final String ADDRESS_TEXTBOX = "addr";
		public static final String CITY_FIELD = "city";
		public static final String STATE_FIELD = "state";
		public static final String PIN_FIELD = "pinno";
		public static final String MOBILE_FIELD = "telephoneno";
		public static final String EMAIL_FIELD = "emailid";
		public static final String PASSWORD_FIELD = "password";
		public static final String SUBMIT_BUTTON = "sub";
		public static final String ACC_SUBMIT_BUTTON = "AccSubmit";
		
	}
}
