@editcustomer
Feature: Validation in Edit Customer page

  @pre_condition
  Scenario Outline: [PRE-Condition] Create new account and new Customer account
      #Register new account
    Given I click Here link button
    When I input "automation@gmail.com" into email field
    Then I click btn Submit button
    And I get userId and password

      #Login with new userID and password
    Given I open Login page
    When I input userId and password into fields
    Then I click Login button

      #Verify Login success
    Then I verify Login success

      #Create new Customer account
    Given I open "New Customer" page
    When I input to "name" textbox with data "<Customer Name>"
    And I click to "m" radio button with Male
    And I input to "dob" date field with data "<Birthday>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Mobile>"
    And I input to EmailField with data "<Email>"
    And I input to "password" textbox with data "<Password>"
    And I click "sub" button
    Then I get Customer ID in "Customer ID" table
    Given I open "Edit Customer" page
    Examples:
      | Customer Name      | Birthday   | Address      | City    | State     | Pin    | Mobile     | Email              | Password |
      | Automation testing | 12/12/2018 | K123 Le Duan | Da Nang | Thanh Khe | 123456 | 0123456789 | autotest@gmail.com | 123123   |


  @TC_01_CustomerIDCannotEmpty
  Scenario: [TC-01] Customer ID cannot be empty
    When I leave "cusid" textbox blank
    Then I verify "message14" error with text "Customer ID is required" display

  @TC_02_CustomerIDMustBeNumeric
  Scenario Outline: [TC-02] Customer ID must be numeric
    When I input to "cusid" date field with data "<Data>"
    Then I verify "message14" error with text "<Error Text>" display
    Examples:
      | Data          | Error Text                 |
      | customerID123 | Characters are not allowed |
      | 123CustomerID | Characters are not allowed |

  @TC_03_CustomerIDCannotHaveFistCharBlank
  Scenario: [TC-03] Customer ID cannot be have first character blank
    When I input to "cusid" textbox with data " customerID"
    Then I verify "message14" error with text "First character can not have space" display

  @TC_04_ValidCustomerID
  Scenario: [TC-04] Valid Customer ID
    When I input Customer ID into "cusid" field
    Then I click "AccSubmit" button

  @TC_05_NameCannotEmpty
  Scenario: [TC-05] Name cannot be empty

  @TC_06_NameCannotNumeric
  Scenario: [TC-06] Name cannot be numeric

  @TC_07_NameCannotHaveSpecialChars
  Scenario: [TC-07] Name cannot have special characters

  @TC_08_AddressCannotEmpty
  Scenario: [TC-08] Address cannot be empty
    When I leave "addr" textarea blank
    Then I verify "message3" error with text "Address Field must not be blank" display

  @TC_09_CityCannotEmpty
  Scenario: [TC-09] City cannot be empty
    When I leave "city" textbox blank
    Then I verify "message4" error with text "City Field must not be blank" display

  @TC_10_CityCannotBeNumeric
  Scenario Outline: [TC-10] City cannot be numeric
    When I input to "city" textbox with data "<Data>"
    Then I verify "message4" error with text "<Error Text>" display
    Examples:
      | Data      | Error Text              |
      | 1234PCity | Numbers are not allowed |
      | City234   | Numbers are not allowed |

  @TC_11_CityCannotHaveSpecialChars
  Scenario Outline: [TC-11] City cannot be have special characters
    When I input to "city" textbox with data "<Data>"
    Then I verify "message4" error with text "<Error Text>" display
    Examples:
      | Data     | Error Text                         |
      | !#@$!@   | Special characters are not allowed |
      | city#!@# | Special characters are not allowed |

  @TC_12_StateCannotEmpty
  Scenario: [TC-12] State cannot be empty
    When I leave "state" textbox blank
    Then I verify "message5" error with text "State must not be blank" display

  @TC_13_StateCannotNumeric
  Scenario Outline: [TC-13] State cannot numeric
    When I input to "state" textbox with data "<Data>"
    Then I verify "message5" error with text "<Error Text>" display
    Examples:
      | Data      | Error Text              |
      | 1234      | Numbers are not allowed |
      | State1234 | Numbers are not allowed |

  @TC_14_StateCannotHaveSpecialChars
  Scenario Outline: [TC-14] State cannot be have special characters
    When I input to "state" textbox with data "<Data>"
    Then I verify "message5" error with text "<Error Text>" display
    Examples:
      | Data      | Error Text                         |
      | !#@$!@    | Special characters are not allowed |
      | State#!@# | Special characters are not allowed |

  @TC_15_PinMustbeNumeric
  Scenario Outline: [TC-15] Pin must be numeric
    When I input to "pinno" textbox with data "<Data>"
    Then I verify "message6" error with text "<Error Text>" display
    Examples:
      | Data    | Error Text                 |
      | 1234Pin | Characters are not allowed |
      | Pin1234 | Characters are not allowed |

  @TC_16_PinCannotEmpty
  Scenario: [TC-16] Pin cannot be empty
    When I leave "pinno" textbox blank
    Then I verify "message6" error with text "PIN Code must not be blank" display

  @TC_17_PinMustHaveSixDigits
  Scenario Outline: [TC-17] Pin must have 6 digits
    When I input to "pinno" textbox with data "<Data>"
    Then I verify "message6" error with text "<Error Text>" display
    Examples:
      | Data | Error Text                  |
      | 1    | PIN Code must have 6 Digits |
      | 123  | PIN Code must have 6 Digits |

  @TC_18_PinCannotHaveSpecialChars
  Scenario Outline: [TC-18] Pin cannot be have special characters
    When I input to "pinno" textbox with data "<Data>"
    Then I verify "message6" error with text "<Error Text>" display
    Examples:
      | Data   | Error Text                         |
      | !#@$!@ | Special characters are not allowed |
      | 123#!@ | Special characters are not allowed |

  @TC_19_TelephoneCannotEmpty
  Scenario: [TC-19] Telephone cannot be empty
    When I leave "telephoneno" textbox blank
    Then I verify "message7" error with text "Mobile no must not be blank" display

  @TC_20_TelephoneCannotHaveSpecialChars
  Scenario Outline: [TC-20] Pin cannot be have special characters
    When I input to "telephoneno" textbox with data "<Data>"
    Then I verify "message7" error with text "<Error Text>" display
    Examples:
      | Data   | Error Text                         |
      | !#@$!@ | Special characters are not allowed |
      | 123#!@ | Special characters are not allowed |

  @TC_21_EmailCannotEmpty
  Scenario: [TC-21] Email cannot be empty
    When I leave "emailid" textbox blank
    Then I verify "message9" error with text "Email-ID must not be blank" display

  @TC_22_EmailMustBeCorrectFormat
  Scenario Outline: [TC-22] Email must be correct format
    When I input to "emailid" textbox with data "<Data>"
    Then I verify "message9" error with text "<Error Text>" display

    Examples:
      | Data          | Error Text            |
      | guru99@gmail  | Email-ID is not valid |
      | guru99        | Email-ID is not valid |
      | Guru99@       | Email-ID is not valid |
      | guru99@gmail. | Email-ID is not valid |

  @TC_23_EmailMustBeFormat
  Scenario Outline: [TC-23] Email must be format
    When I input to "emailid" textbox with data "<Data>"
    Then I verify "message9" error with text "<Error Text>" display

    Examples:
      | Data            | Error Text            |
      | guru99@gmail    | Email-ID is not valid |
      | guru99          | Email-ID is not valid |
      | Guru99@         | Email-ID is not valid |
      | guru99@gmail.   | Email-ID is not valid |
      | @gmail.         | Email-ID is not valid |
      | guru99gmail.com | Email-ID is not valid |