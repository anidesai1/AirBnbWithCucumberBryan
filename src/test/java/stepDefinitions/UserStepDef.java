package stepDefinitions;

import com.airbnb.model.Room;
import com.airbnb.model.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

public class UserStepDef {
    RestClient restClient;
    String uriBase;
    User user;
    @Given("I have a user spring endpoint")
    public void i_have_a_user_spring_endpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }
    @When("I call the user endpoint by {string} name")
    public void i_call_the_user_endpoint_by_name(String name) {
        user = restClient.get().uri(uriBase + "/user?name=" + name).retrieve().body(User.class);
    }
    @Then("{string} is the result from my server")
    public void is_the_result_from_my_server(String expectedName) {
        Assertions.assertEquals(expectedName, user.getName());
    }


}
