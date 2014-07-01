Feature: Hello World
  This is just my first trial of Cucumber
  Scenario Outline: Try Hello World
    Given I'm here
    Then Say hello words "<hello words>"
  Examples:
    | hello words |
    | hi          |
    | hello       |
    | anybody?    |
