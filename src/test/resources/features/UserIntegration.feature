Feature: I want to be able to integrate user test Spring endpoints

  Scenario Outline:
    Given I have a user spring endpoint
    When I call the user endpoint by <User> name
    Then <Server> is the result from my server

    Examples:
      | User          | Server |
      | "Ani"         | "Ani" |
      | "Dhwani"      | "Dhwani" |

