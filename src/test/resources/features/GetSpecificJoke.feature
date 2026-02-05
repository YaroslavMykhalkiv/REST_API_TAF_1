Feature: Random Joke

  As a consumer of Official Joke API
  User wants to get specific joke

  @smoke
  Scenario Outline: Get few jokes
    Given Official Joke API is available
    When user gets a joke under <Joke ID> ID
    Then response status code should be "OK"
    And response should contains exactly those parameters:
      | id   | type   | setup   | punchline   |
      | <Joke ID> | <type> | <setup> | <punchline> |

    Examples:
      | Joke ID | type        | setup                                        | punchline               |
      | 4       | general     | What do you call a belt made out of watches? | A waist of time.        |
      | 32      | programming | Which song would an exception sing?          | Can't catch me - Avicii |
