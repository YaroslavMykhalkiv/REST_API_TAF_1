package cucumber.steps;

import cucumber.helpers.JokeApiClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APIJokesSteps {

    private Response response;
    @Autowired
    private JokeApiClient jokeApiClient;

    @Given("Official Joke API is available")
    public void apiIsAvailable() {
        assertEquals(200,jokeApiClient.getByEndpoint("").statusCode(), "Joke API is not working!");
    }

    @When("user gets a random joke")
    public void userGetsRandomJoke() {
        response = jokeApiClient.getRandomJoke();
    }

    @Then("response status code should be {string}")
    public void verifyStatusCode(String statusCode) {
        switch (statusCode){
            case "OK":
                assertEquals(200, response.statusCode());
                break;
        }
    }

    @And("response body should contain fields:")
    public void responseBodyShouldContainFields(List<String> fields) {
        for (String field : fields) {
            response.then().body(field, notNullValue());
        }
    }

    @And("response should contains exactly {int} jokes")
    public void responseShouldContainsExactlyJokesNumberJokes(int jokesNumber) {
        List<?> jokes = response.jsonPath().getList("$");
        assertEquals(jokesNumber, jokes.size(), "API should return exactly "+jokesNumber+" jokes");
    }

    @When("user gets {int} random jokes")
    public void userGetsJokesNumberRandomJokes(int jokesNumber) {
        response = jokeApiClient.getRandomJoke(jokesNumber);
    }

}
