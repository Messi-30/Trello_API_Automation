Feature: First API call to Trello API using Rest-Assured
  Scenario: Get an Trello Board
    Given i perform GET operation for endpoint "/1/boards/{board_id}/"
    And with path parameter board_id
    Then I should see the board name as "Trello Board"

  Scenario: Create an Trello Board
    Given i perform POST operation for endpoint "/1/boards/" with query parameter
      |QueryParameter |value    |
      |name           |Learn C#|
    Then I should see the board name as "Learn Java"

