@payment
Feature: Payment

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

  @TC_01_CreateNewCustomerAccount
  Scenario Outline: [TC-01] Create New Customer Account And Check Success
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
    Then I verify "Customer Registered Successfully!!!" display
    And I verify "Customer Name" correct with data "<Customer Name>"
    And I verify "Gender" correct with data "<Gender>"
    And I verify "Address" correct with data "<Address>"
    And I verify "City" correct with data "<City>"
    And I verify "State" correct with data "<State>"
    And I verify "Pin" correct with data "<Pin>"
    And I verify "Mobile No." correct with data "<Mobile>"
    And I get Customer ID in "Customer ID" table

    Examples: 
      | Customer Name      | Gender | Birthday   | Address      | City    | State     | Pin    | Mobile     | Email              | Password |
      | Automation testing | male   | 11/11/2018 | K123 Le Duan | Da Nang | Thanh Khe | 123456 | 0123456789 | autotest@gmail.com |   123123 |

  @TC_02_EditNewCustomerAccount
  Scenario Outline: [TC-02] Edit new Customer and check success
    Given I open "Edit Customer" page
    When I input Customer ID into "cusid" field
    Then I click "AccSubmit" button
    When I input to disable "addr" textarea with data "<Address>"
    And I input to disable "city" textbox with data "<City>"
    And I input to disable "state" textbox with data "<State>"
    And I input to disable "pinno" textbox with data "<Pin>"
    And I input to disable "telephoneno" textbox with data "<Mobile>"
    And I input to disable EmailField with data "<Email>"
    And I click "sub" button
    Then I verify "Address" correct with data "<Address>"
    And I verify "City" correct with data "<City>"
    And I verify "State" correct with data "<State>"
    And I verify "Pin" correct with data "<Pin>"
    And I verify "Mobile No." correct with data "<Mobile>"

    Examples: 
      | Customer Name      | Gender | Birthday   | Address        | City     | State | Pin    | Mobile    | Email             | Password |
      | Automation testing | male   | 11/11/2018 | K999 Nui Thanh | Pho Bien | Texas | 987654 | 454527612 | testing@gmail.com |   123123 |

  @TC_03_AddNewAccount
  Scenario Outline: [TC-03] Add new account and check success
    Given I open "New Account" page
    When I input Customer ID into "cusid" field
    And I select in "selaccount" dropdown list with data "<Account Type>"
    And I input to "inideposit" textbox with data "<Deposit>"
    Then I click "button2" button
    And I get Account ID in "Account ID" table
    And I verify "Account Generated Successfully!!!" display
    And I verify "Current Amount" correct with data "<Current Amount>"

    Examples: 
      | Account Type | Deposit | Current Amount |
      | Current      |   50000 |          50000 |

  @TC_04_TransferMoneyIntoCurrentAccount
  Scenario Outline: [TC-04] Transfer money into current account and check balance
    Given I open "Deposit" page
    When I input to Account ID into "accountno" field
    And I input to "ammount" textbox with data "<Amount>"
    And I input to "desc" textbox with data "<Description>"
    And I click "AccSubmit" button
    Then I verify "Transaction details of Deposit" display
    And I verify "Current Balance" correct with data "<Current Balance>"

    Examples: 
      | Amount | Description | Current Balance |
      |   5000 | Deposit     |           55000 |

  @TC_05_WithdrawlMoneyFromCurrentAccount
  Scenario Outline: [TC-05] Withdrawl money from current account and check balance
    Given I open "Withdrawal" page
    When I input to Account ID into "accountno" field
    And I input to "ammount" textbox with data "<Amount>"
    And I input to "desc" textbox with data "<Description>"
    And I click "AccSubmit" button
    And I verify "Transaction details of Withdrawal" display
    And I verify "Current Balance" correct with data "<Current Balance>"

    Examples: 
      | Amount | Description | Current Balance |
      |  15000 | Withdraw    |           40000 |

  @TC_06_TransferMoneyToAnotherAccount
  Scenario Outline: [TC-06] Transfer money to another account and check amount
    #Create second account
    Given I open "New Account" page
    When I input Customer ID into "cusid" field
    And I select in "selaccount" dropdown list with data "<Account Type>"
    And I input to "inideposit" textbox with data "<Deposit>"
    Then I click "button2" button
    And I get second Account ID in "Account ID" table
    #Fund Transfer
    Given I open "Fund Transfer" page
    When I input to Account ID into "payersaccount" field
    And I input second Account ID into "payeeaccount" field
    And I input to "ammount" textbox with data "<Amount>"
    And I input to "desc" textbox with data "<Description>"
    And I click "AccSubmit" button
    Then I verify "Fund Transfer Details" display
    And I verify "Amount" correct with data "<Amount>"

    Examples: 
      | Account Type | Deposit | Amount | Description   | Amount |
      | Current      |   50000 |  10000 | Fund Transfer |  10000 |

  @TC_07_CheckCurrentAccountBalance
  Scenario: [TC-07] Check current account balance equal 30.000
    Given I open "Balance Enquiry" page
    When I input to Account ID into "accountno" field
    And I click "AccSubmit" button
    Then I verify "Balance Details for Account" display
    And I verify "Balance" correct with data "30000"

  @TC_08_DeleteAccount
  Scenario: [TC-08] Delete account of this customer account
    Given I open "Delete Account" page
    When I input to Account ID into "accountno" field
    And I click "AccSubmit" button and accept delete
    Then I verify text "Account Deleted Successfully" on Alert and accept Alert

  @TC_09_DeleteCustomerAccount
  Scenario: [TC-09] Delete customer account and check success
    Given I open "Delete Customer" page
    When I input Customer ID into "cusid" field
    And I click "AccSubmit" button and accept delete
    Then I verify text "Customer Deleted Successfully" on Alert and accept Alert
