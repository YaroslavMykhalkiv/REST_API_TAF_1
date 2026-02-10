package cucumber.functions.impl;

import cucumber.functions.JokeApiFunctions;
import cucumber.helpers.JokeApiClient;
import io.cucumber.datatable.DataTable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Component
public class JokeApiFunctionsImpl implements JokeApiFunctions {

    @Autowired
    private JokeApiClient jokeApiClient;

    private Response response;

    @Override
    public void jokeApiIsValid() {
        assertEquals(200,jokeApiClient.getByEndpoint("").statusCode(), "Joke API is not working!");
    }

    @Override
    public void getRandomJoke() {
        response = jokeApiClient.getRandomJoke();
    }

    @Override
    public void getRandomJoke(int jokesNumber) {
        response = jokeApiClient.getRandomJoke(jokesNumber);
    }

    @Override
    public void verifyStatusCode(String statusCode) {
        switch (statusCode){
            case "OK":
                assertEquals(200, response.statusCode());
                break;
        }
    }

    @Override
    public void validateAllRequiredFields(List<String> fields) {
        for (String field : fields) {
            response.then().body(field, notNullValue());
        }
    }

    @Override
    public void validateJokesAmountFromResponse(int jokesNumber) {
        List<?> jokes = response.jsonPath().getList("$");
        assertEquals(jokesNumber, jokes.size(), "API should return exactly "+jokesNumber+" jokes");
    }

    @Override
    public void getSpecificJoke(int jokeID) {
        response = jokeApiClient.getJokeById(jokeID);
    }

    @Override
    public void validateFieldsForSpecificJoke(DataTable table) {
        Map<String, String> data = table.asMaps().get(0);
        JsonPath jsonPath = response.jsonPath();
        data.keySet().forEach(key->{
            assertEquals(data.get(key),jsonPath.getString(key), "Value for key/parameter '"+ key +"' is incorrect.");
        });
    }
}
