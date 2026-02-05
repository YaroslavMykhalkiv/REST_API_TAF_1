Feature: Random Joke

  As a consumer of Official Joke API
  User want to get specific number of random jokes

  @smoke
  Scenario Outline: Get few jokes
    Given Official Joke API is available
    When user gets <Jokes number> random jokes
    Then response status code should be "OK"
    And response should contains exactly <Jokes number> jokes
    And response body should contain fields:
      | id        |
      | type      |
      | setup     |
      | punchline |

    Examples:
      | Jokes number |
      | 3            |
      | 4            |
      | 6            |
