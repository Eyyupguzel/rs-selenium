Feature: signUp

  Scenario: Sign up - Succes
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Click the sign up tab
    And Enter the unique username "eypgzl123"
    And Enter the unique email "eyyup.guzel@ozu.edu.tr"
    And Enter the first password "Eegzll123-"
    And Enter the password "Eegzll123-" again
    When Click the sign up button
    Then Verify successs sign up message

  Scenario: Sign up - Used Email
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Click the sign up tab
    And Enter the unique username "eypgzl1234"
    And Enter the unique email "eyyup.guzel@roofstacks.com"
    And Enter the first password "Eypgzll1903-"
    And Enter the password "Eypgzll1903-" again
    When Click the sign up button
    Then Verify error sign up message email already registered

  Scenario: Sign up - Used Username
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Click the sign up tab
    And Enter the unique username "eypgzl123"
    And Enter the unique email "eyyup.guze3l@roofstacks.com"
    And Enter the first password "Eypgzll1903-"
    And Enter the password "Eypgzll1903-" again
    When Click the sign up button
    Then Verify error sign up message username already registered
