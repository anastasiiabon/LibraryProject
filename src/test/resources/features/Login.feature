Feature: Login
  As a User should be able to log in with username and password

  Background:
    Given user is on the landing page

  @s_o
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see dashboard page

    Examples:
      | role          |
      | librarian |
      | student |



  @negative_login @smoke
  Scenario: Invalid password
    When user logs in with "student@library" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_outline
  Scenario Outline: Invalid login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples: data set
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | wrong1   | bad      | Invalid user name or password. |
      | wrong2   | bad      | Invalid user name or password. |
      | wrong3   | bad      | Invalid user name or password. |