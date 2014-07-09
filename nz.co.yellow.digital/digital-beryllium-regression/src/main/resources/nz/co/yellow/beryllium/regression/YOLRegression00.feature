Feature: No GUIs
  Scenario: Just to verify some no GUIs functions
    Given Start testing
    And   Start step 1
    And   Start step 2
    Then  Open product page with urls:
    | products      | urls                | stages |
    | Yellow        | http://yellow.co.nz | released |
    | White         | http://white.co.nz  | in-progress |
    | Finda         | http://finda.co.nz  | not started |