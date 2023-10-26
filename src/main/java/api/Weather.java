package api;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Weather extends Base{

    private final String API_CURRENT_ENDPOINT  = "/current";


    @Step("Get current weather with API KEY : {access_key} / Location : {location}")
    public ValidatableResponse currentWeather(String access_key , String location , String language) {
        return given()
                .spec(getSpec())
                .queryParam("access_key" , access_key)
                .queryParam("query" , location)
                .queryParam("language" , language)
                .when()
                .get(API_CURRENT_ENDPOINT)
                .then();
    }

    @Step("Get current weather with API KEY : {access_key} / Location : {location} / {url}")
    public ValidatableResponse currentWeather(String url,String access_key , String location ,String language) {
        return given()
                .spec(getSpec(url))
                .queryParam("access_key" , access_key)
                .queryParam("query" , location)
                .queryParam("language" , language)
                .when()
                .get(API_CURRENT_ENDPOINT)
                .then();
    }

}
