package cucumber.helpers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public interface JokeApiClient {

    Response getByEndpoint(String endpoint);

    Response getRandomJoke();

    Response getRandomJoke(int jokesNumber);

    Response getJokeById(int jokeID);
}
