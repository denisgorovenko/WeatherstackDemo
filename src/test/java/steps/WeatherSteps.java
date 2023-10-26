package steps;

import api.ApiErrorResponseModel;
import api.Weather;
import api.WeatherResponseModel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Util;
import java.util.List;
import java.util.Map;



public class WeatherSteps{

    private final String API_KEY = "1fbe1e97050e60513cd05a18104cd5b5";
    public Weather weather = new Weather();
    public Util util = new Util();
    public WeatherResponseModel weatherResponseModel = new WeatherResponseModel();
    public ApiErrorResponseModel apiErrorResponseModel = new ApiErrorResponseModel();




    @When("I request the current weather for city {string}")
    public void iRequestTheCurrentWeatherFor(String cityName) {
        weatherResponseModel = weather.currentWeather(API_KEY,cityName,"").extract().as(WeatherResponseModel.class);
    }

    @Then("the response should contain the values")
    public void theResponseShouldHaveValues(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps();
        for (Map<String, String> expectedRow : expectedData) {
            util.compareWeatherField(expectedRow.get("Name") , expectedRow.get("Value"), weatherResponseModel);
        }
    }


    @When("I request the current weather with wrong access key")
    public void iRequestTheCurrentWeatherWithWrongAccessKey() {
        apiErrorResponseModel = weather.currentWeather("API_KEY","New York","").extract().as(ApiErrorResponseModel.class);
    }

    @Then("response contains an error code {int} and type {string}")
    public void responseContainsAnErrorCodeAndType(int codeVal, String typeVal) {
        Assert.assertEquals("Code :", codeVal , apiErrorResponseModel.error.code);
        Assert.assertEquals("Type :", typeVal , apiErrorResponseModel.error.type);
    }

    @When("I request the current weather with invalid \\(or missing) query")
    public void iRequestTheCurrentWeatherWithInvalidOrMissingQuery() {
        apiErrorResponseModel = weather.currentWeather(API_KEY,"","").extract().as(ApiErrorResponseModel.class);
    }

    @When("I request the current weather with valid language")
    public void iRequestTheCurrentWeatherWithValidLanguage() {
        apiErrorResponseModel = weather.currentWeather(API_KEY,"New York","ru").extract().as(ApiErrorResponseModel.class);
    }

    @When("I request the current weather with wrong API function")
    public void iRequestTheCurrentWeatherWithWrongAPIFunction() {
        apiErrorResponseModel = weather.currentWeather("http://api.weatherstack.com/test",API_KEY,"New York", "").extract().as(ApiErrorResponseModel.class);
    }
}
