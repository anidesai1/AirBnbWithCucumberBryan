Feature:
  I want to be able to integration test Spring endpoints

  Scenario:
    Given I have a Rest Spring Endpoint
    Given the following rooms are available to rent
      | Room Name  |
      | Cliffhanger |
      | Slickrock  |
    When I call the room endpoint by name for <Room>
    Then <Server> is the result from the server

    Examples:
      | Room          | Server |
      | "Cliffhanger" | "Cliffhanger" |
      | "Slickrock"   | "Slickrock" |