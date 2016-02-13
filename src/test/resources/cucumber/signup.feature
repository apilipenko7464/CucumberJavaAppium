@signup
Feature: Instagram signup

  Scenario: As Instagram user, I can create new account
    Given I type "alfamiliya" into username field
    And I type "password" into password field
    Then I tap on Signup button
    And I verify that I singed up