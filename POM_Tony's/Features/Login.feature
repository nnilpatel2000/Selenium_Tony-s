Feature: Login page feature

  Scenario Outline: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://www.tonysfreshmarket.com"
    Then User closes welcome message
    Then User clicks Sign in
    When user gets the title of the Login page
    Then Login page title should be "My Account - Tony's Fresh Market"
    Then User enters Email as "<email>" and Password as "<password>"
    Then Create an account here link should be displayed
    Then Forgot your password link should be displayed
    Then User click on Login
    Then Home Page Title should be "Home - Tony's Fresh Market"
    When User click on Sign out link
    Then Close browser

    Examples: 
      | email                    | password  | expected |
      | nnilpatel.2000@gmail.com | Nil@12345 | Valid    |
