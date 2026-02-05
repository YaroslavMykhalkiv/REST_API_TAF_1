package cucumber.helpers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

/**
 * JokeApiClient is an interface for interacting with a REST API
 * that provides jokes.
 *
 * @author Yaroslav
 */
@Component
public interface JokeApiClient {

    /**
     * Sends a GET request to the specified API endpoint.
     *
     * @param endpoint the relative API endpoint (e.g., "/jokes/random")
     * @return the API response wrapped in a {@link Response} object
     */
    Response getByEndpoint(String endpoint);

    /**
     * Retrieves a single random joke from the API.
     *
     * @return the API response containing the random joke
     */
    Response getRandomJoke();

    /**
     * Retrieves a specified number of random jokes from the API.
     *
     * @param jokesNumber the number of random jokes to retrieve
     * @return the API response containing the requested number of jokes
     */
    Response getRandomJoke(int jokesNumber);

    /**
     * Retrieves a joke from the API by its unique ID.
     *
     * @param jokeID the ID of the joke to retrieve
     * @return the API response containing the joke with the specified ID
     */
    Response getJokeById(int jokeID);
}

