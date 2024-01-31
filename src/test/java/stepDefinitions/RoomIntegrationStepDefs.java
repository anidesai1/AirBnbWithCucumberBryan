package stepDefinitions;

import com.airbnb.controller.RoomController;
import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomIntegrationStepDefs {
    @Autowired
    RoomController roomController;

    Room room;
    @Given("I have a Spring endpoint")
    public void iHaveASpringEndpoint() {
        Assertions.assertNotNull(roomController); //to check if room controller is wired up correctly
    }

    @When("I call the endpoint by name for rooms")
    public void iCallTheEndpointByNameForRooms() {
        room = roomController.findByName("Cliffhanger");
    }

    @Then("Cliffhanger should return from the server")
    public void cliffhangerShouldReturnFromTheServer() {
        Assertions.assertEquals("Cliffhanger", room.getName());
    }
}
