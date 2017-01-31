Feature: Send
  @send
  Scenario: Send screen elements
    Given I am on the Send Screen
    Then I should see "Enable Dynamic Shortcut"

  @send
  Scenario Outline: : ShortCut Check state
    Given I am on the Send Screen
    When Enable shortcut is <checked>
    Then I should see checkmark <enabled>

    Examples:
      | checked | enabled |
      | false | false |
      | true | true |