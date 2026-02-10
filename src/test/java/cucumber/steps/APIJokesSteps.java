package cucumber.steps;

import cucumber.functions.JokeApiFunctions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class APIJokesSteps {

    @Autowired
    private JokeApiFunctions jokeApiFunctions;

    @Given("Official Joke API is available")
    public void apiIsAvailable() {
        jokeApiFunctions.jokeApiIsValid();
    }

    @When("user gets a random joke")
    public void userGetsRandomJoke() {
        jokeApiFunctions.getRandomJoke();
    }

    @Then("response status code should be {string}")
    public void verifyStatusCode(String statusCode) {
        jokeApiFunctions.verifyStatusCode(statusCode);
    }

    @And("response body should contain fields:")
    public void responseBodyShouldContainFields(DataTable table) {
        jokeApiFunctions.validateAllRequiredFields(table.asList());
    }

    @And("response should contains exactly {int} jokes")
    public void responseShouldContainsExactlyJokesNumberJokes(int jokesNumber) {
        jokeApiFunctions.validateJokesAmountFromResponse(jokesNumber);
    }

    @When("user gets {int} random jokes")
    public void userGetsJokesNumberRandomJokes(int jokesNumber) {
        jokeApiFunctions.getRandomJoke(jokesNumber);
    }

    @When("user gets a joke under {int} ID")
    public void userGetsAJokeUnderJokeID(int jokeID) {
        jokeApiFunctions.getSpecificJoke(jokeID);
    }

    @And("response should contains exactly those parameters:")
    public void responseShouldContainsExactlyThoseParameters(DataTable table) {
        jokeApiFunctions.validateFieldsForSpecificJoke(table);
    }
}
