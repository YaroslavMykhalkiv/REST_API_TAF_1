package cucumber.helpers.impl;

import cucumber.helpers.JokeApiClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JokeApiClientImpl implements JokeApiClient {
    @Value("${api.jokes.url}")
    private String url;

    @PostConstruct
    public void init() {
        RestAssured.baseURI = url;
    }

    public Response getByEndpoint(String endpoint){
        return RestAssured.given()
                .when()
                .get(endpoint);
    }

    public Response getRandomJoke(){
        return getByEndpoint("/random_joke");
    }

    public Response getRandomJoke(int jokesNumber){
        return getByEndpoint("/jokes/random/"+jokesNumber);
    }
}
