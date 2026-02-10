package cucumber.functions;

import io.cucumber.datatable.DataTable;
import java.util.List;

/**
 * Defines high-level operations and validations for interacting with
 * the Official Joke API.
 *
 * <p>
 * This interface encapsulates:
 * <ul>
 *   <li>API request execution</li>
 *   <li>Response validation and assertions</li>
 *   <li>Business-level test actions used by Cucumber step definitions</li>
 * </ul>
 *
 * <p>
 */
public interface JokeApiFunctions {

    /**
     * Verifies that the Official Joke API is available and properly configured.
     *
     * <p>
     * Typically sets or validates the base URI and ensures that the API
     * can be reached before executing test scenarios.
     */
    void jokeApiIsValid();

    /**
     * Sends a request to retrieve a single random joke.
     *
     * <p>
     * The response is stored internally for further validation steps.
     */
    void getRandomJoke();

    /**
     * Sends a request to retrieve a specific number of random jokes.
     *
     * @param jokesNumber number of random jokes to be requested
     */
    void getRandomJoke(int jokesNumber);

    /**
     * Verifies that the HTTP response status code matches the expected value.
     *
     * @param statusCode expected HTTP status code (e.g. "200", "OK")
     */
    void verifyStatusCode(String statusCode);

    /**
     * Validates that the response body contains all required fields.
     *
     * <p>
     * This method is typically used with Cucumber DataTables converted
     * to a list of expected JSON field names.
     *
     * @param fields list of expected field names in the response body
     */
    void validateAllRequiredFields(List<String> fields);

    /**
     * Validates that the response contains exactly the expected number of jokes.
     *
     * @param jokesNumber expected number of jokes in the response
     */
    void validateJokesAmountFromResponse(int jokesNumber);

    /**
     * Sends a request to retrieve a joke by its unique identifier.
     *
     * @param jokeID unique identifier of the joke
     */
    void getSpecificJoke(int jokeID);

    /**
     * Validates that a specific joke response contains exactly the expected fields.
     *
     * <p>
     * The expected fields are provided via a Cucumber {@link DataTable},
     * allowing readable and flexible validation in feature files.
     *
     * @param table DataTable containing expected response field names
     */
    void validateFieldsForSpecificJoke(DataTable table);
}
