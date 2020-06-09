@newcustomer
Feature: Validation in New Customer page

  @pre_condition
  Scenario: [PRE-Condition] Create new account and login
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
    Given I open "New Customer" page

  @TC_01_NameCannotBeEmpty
  Scenario: [TC-01] Name cannot be empty
    When I leave "name" textbox blank
    Then I verify "message" error with text "Customer name must not be blank" display


  @TC_02_NameCannotNumeric
  Scenario Outline: [TC-02] Name cannot numeric
    When I input to "name" textbox with data "<Data>"
    Then I verify "message" error with text "<Error Text>" display
    Examples:
      | Data     | Error Text              |
      | 1234     | Numbers are not allowedd |
      | name1234 | Numbers are not allowed |

  @TC_03_NameCannotHaveSpecialChars
  Scenario Outline: [TC-03] Name cannot be have special characters
    When I input to "name" textbox with data "<Data>"
    Then I verify "message" error with text "<Error Text>" display
    Examples:
      | Data     | Error Text                         |
      | !#@$!@   | Special characters are not allowed |
      | name#!@# | Special characters are not allowed |

  @TC_04_NameCannotHaveFistCharBlank
  Scenario: [TC-04] Name cannot be have first character blank
    When I input to "name" textbox with data " testname"
    Then I verify "message" error with text "First character can not have space" display

  @TC_05_AddressCannotEmpty
  Scenario: [TC-05] Address cannot be empty
    When I leave "addr" textarea blank
    Then I verify "message3" error with text "Address Field must not be blank" display

  @TC_06_AddressCannotHaveFistCharBlank
  Scenario: [TC-06] Address cannot be have first character blank
    When I input to "addr" textarea with data " testaddress"
    Then I verify "message3" error with text "First character can not have space" display

  @TC_07_CityCannotEmpty
  Scenario: [TC-07] City cannot be empty
    When I leave "city" textbox blank
    Then I verify "message4" error with text "City Field must not be blank" display

  @TC_08_CityCannotNumeric
  Scenario Outline: [TC-08] City cannot numeric
    When I input to "city" textbox with data "<Data>"
    Then I verify "message4" error with text "<Error Text>" display
    Examples:
      | Data     | Error Text              |
      | 1234     | Numbers are not allowed |
      | city1234 | Numbers are not allowed |

  @TC_09_CityCannotHaveSpecialChars
  Scenario Outline: [TC-09] City cannot be have special characters
    When I input to "city" textbox with data "<Data>"
    Then I verify "message4" error with text "<Error Text>" display
    Examples:
      | Data     | Error Text                         |
      | !#@$!@   | Special characters are not allowed |
      | city#!@# | Special characters are not allowed |

  @TC_10_CityCannotHaveFistCharBlank
  Scenario: [TC-10] City cannot be have first character blank
    When I input to "city" textbox with data " testCity"
    Then I verify "message4" error with text "First character can not have space" display

  @TC_11_StateCannotEmpty
  Scenario: [TC-11] State cannot be empty
    When I leave "state" textbox blank
    Then I verify "message5" error with text "State must not be blank" display

  @TC_12_StateCannotNumeric
  Scenario Outline: [TC-12] State cannot numeric
    When I input to "state" textbox with data "<Data>"
    Then I verify "message5" error with text "<Error Text>" display
    Examples:
      | Data      | Error Text              |
      | 1234      | Numbers are not allowed |
      | State1234 | Numbers are not allowed |

  @TC_13_StateCannotHaveSpecialChars
  Scenario Outline: [TC-13] State cannot be have special characters
    When I input to "state" textbox with data "<Data>"
    Then I verify "message5" error with text "<Error Text>" display
    Examples:
      | Data      | Error Text                         |
      | !#@$!@    | Special characters are not allowed |
      | State#!@# | Special characters are not allowed |

  @TC_14_StateCannotHaveFistCharBlank
  Scenario: [TC-14] State cannot be have first character blank
    When I input to "state" textbox with data " testState"
    Then I verify "message5" error with text "First character can not have space" display

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

  @TC_19_PinCannotHaveFistCharBlank
  Scenario: [TC-19] Pin cannot be have first character blank
    When I input to "pinno" textbox with data " 1234"
    Then I verify "message6" error with text "First character can not have space" display

  @TC_20_PinCannotHaveBlankSpace
  Scenario: [TC-20] Pin cannot be have blank space
    When I input to "pinno" textbox with data "1 123"
    Then I verify "message6" error with text "Characters are not allowed" display

  @TC_21_TelephoneCannotEmpty
  Scenario: [TC-21] Telephone cannot be empty
    When I leave "telephoneno" textbox blank
    Then I verify "message7" error with text "Mobile no must not be blank" display

  @TC_22_TelephoneCannotHaveFistCharBlank
  Scenario: [TC-22] Telephone cannot be have first character blank
    When I input to "telephoneno" textbox with data " 1234"
    Then I verify "message7" error with text "First character can not have space" display

  @TC_23_TelephoneCannotHaveBlankSpace
  Scenario: [TC-23] Telephone cannot be have blank space
    When I input to "telephoneno" textbox with data "331 123"
    Then I verify "message7" error with text "Characters are not allowed" display

  @TC_24_TelephoneCannotHaveSpecialChars
  Scenario Outline: [TC-24] Pin cannot be have special characters
    When I input to "telephoneno" textbox with data "<Data>"
    Then I verify "message7" error with text "<Error Text>" display
    Examples:
      | Data   | Error Text                         |
      | !#@$!@ | Special characters are not allowed |
      | 123#!@ | Special characters are not allowed |

  @TC_25_EmailCannotEmpty
  Scenario: [TC-25] Email cannot be empty
    When I leave "emailid" textbox blank
    Then I verify "message9" error with text "Email-ID must not be blank" display

  @TC_26_EmailMustBeCorrectFormat
  Scenario Outline: [TC-26] Email must be correct format
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

  @TC_27_EmailCannotHaveBlankSpace
  Scenario: [TC-27] Email cannot be have blank space
    When I input to "emailid" textbox with data "email 123"
    Then I verify "message9" error with text "Email-ID is not valid" display