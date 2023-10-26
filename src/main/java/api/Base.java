package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Base {

    private final String BASE_URL = "http://api.weatherstack.com";

    @Step("Preparation of a query with url :"+BASE_URL)
    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
    }

    @Step("Preparation of a query with custom url : {base_url}")
    protected RequestSpecification getSpec(String base_url) {
        return new RequestSpecBuilder()
                .setBaseUri(base_url)
                .build();
    }

}
