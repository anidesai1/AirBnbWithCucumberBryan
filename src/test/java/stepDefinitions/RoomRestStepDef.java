package stepDefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

public class RoomRestStepDef {
    RestClient restClient;
    String uriBase;
    Room room;
    @Given("I have a Rest Spring Endpoint")
    public void iHaveARestSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }
    @When("I call the room endpoint by name for {string}")
    public void i_call_the_room_endpoint_by_name_for(String roomName) {
        room = restClient.get().uri(uriBase+ "/room?name=" + roomName).retrieve().body(Room.class);
    }

    @Then("{string} is the result from the server")
    public void is_the_result_from_the_server(String expectedName) {
        Assertions.assertEquals(expectedName, room.getName());
    }
}
