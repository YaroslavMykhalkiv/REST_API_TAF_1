Feature: Random Joke

  As a consumer of Official Joke API
  User wants to get random joke

  @smoke
  Scenario: Get a random joke
    Given Official Joke API is available
    When user gets a random joke
    Then response status code should be "OK"
    And response body should contain fields:
      | id        |
      | type      |
      | setup     |
      | punchline |