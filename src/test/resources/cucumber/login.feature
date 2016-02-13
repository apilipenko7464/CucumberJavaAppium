@login
Feature: Instagram login

  @oneLogin
  Scenario: Login as Igor
    When I tap on Login button
    Then I type "igor" into username field
    And I type "password1" into password field
    Then I tap on Login button
    And I verify user is logged in

  Scenario Outline: Login as Different Users
    When I tap on Login button
    Then I type "<username>" into username field
    And I type "<password>" into password field
    Then I tap on Login button
    And I verify user is logged in
    Examples:
      |username  | password |
      |igor      |password  |
      |alex      |password  |

  @wrongLogin
  Scenario: Login with wrong password
    Given I tap on Login button
    Then I type "igor" into username field
    And I type "vsdfjnv" into password field
    Then I tap on Login button
    And I verify that login is failed



