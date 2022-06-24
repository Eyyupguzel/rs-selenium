Feature: Login


  Scenario: Login Goart Market With Email
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Type to email "email" and password "password"
    And Click remember me button
    When Click login button
    Then Verify I am in the home page

  Scenario: Login Goart Market With Email
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Type to username "username" and password "password"
    And Click remember me button
    When Click login button
    Then Verify I am in the home page



  Scenario Outline: Login Goart - Username and Password Wrong
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Type to "<email>" and "<password>" outline
    And Click remember me button
    When Click login button
    Then Verify username or password is wrong error message
    Examples:
      | email | password |
      | eypgzl | 123456 |
      | admin@goart.com | 112233 |
      | admin@goar.comm | 112233 |

  Scenario Outline: Login Goart - Username and Password Empty
    Given Go to the goart website
    And Click sign in button
    Then Verify I am in the login page
    And Type to "<email>" and "<password>" outline
    And Click remember me button
    When Click login button
    Then Verify required error message
    Examples:
      | email | password |
      |  | 112233 |
      | admin@goar.comm |  |
      |  |  |


