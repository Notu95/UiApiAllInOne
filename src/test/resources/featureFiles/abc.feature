#@tag
Feature: Lock-Unlock of Credit Card

  @tag1
  Scenario: Lock the unlocked card
    Given load the application 
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Unlock the locked card
    Given load the application <url>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | url  | value | status  |
      | https://www.google.com |     5 | success |
