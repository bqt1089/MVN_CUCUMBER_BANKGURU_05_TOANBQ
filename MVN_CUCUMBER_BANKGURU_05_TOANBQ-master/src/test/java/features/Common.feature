Feature: Title of feature
  I want to use this template for feature file

  Scenario: Common step
    # ------------ ACTION -------------- #
    # Text box
    And I input to "<string>" textbox with data "<string>"

    And I input "<string>" into email field
    And I input Customer ID into "<string>" field
    And I input to Account ID into "<string>" field
    And I input second Account ID into "<string>" field

    And I input to disable "<string>" textarea with data "<string>"
    And I input to "<string>" date field with data "<string>"
    And I input to disable EmailField with data "<string>"

    # ---------------- Disable text box --------------#
    And I input to disable "<string>" textarea with data "<string>"

    # ---------------- Verify --------------#
    And I verify "<string>" display
    And I verify "<string>" correct with data "<string>"
    And I verify "<string>" error with text "<string>" display
    And I verify text "<string>" on Alert and accept Alert

    # ---------------- DropDown--------------#
    And I select in "<string>" dropdown list with data "<string>"
    
    # ---------------- Click --------------#
    And I click "<string>" button
    And I click to "<string>" radio button with Male

    # ---------------- Click --------------#
    And I wait in "5" seconds