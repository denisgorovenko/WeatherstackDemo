package utils;

import api.WeatherResponseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.WeatherSteps;

public class Util {

    public static final Logger logger = LogManager.getLogger(WeatherSteps.class);

    public void compareWeatherField(String fieldName, String expectedValue, WeatherResponseModel weatherResponseModel) {
        switch (fieldName) {
            case "type":
                compareField(fieldName, expectedValue, weatherResponseModel.getRequest().getType());
                break;
            case "query":
                compareField(fieldName, expectedValue, weatherResponseModel.getRequest().getQuery());
                break;
            case "language":
                compareField(fieldName, expectedValue, weatherResponseModel.getRequest().getLanguage());
                break;
            case "name":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getName());
                break;
            case "country":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getCountry());
                break;
            case "region":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getRegion());
                break;
            case "lat":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getLat());
                break;
            case "localtime":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getLocaltime());
                break;
            case "utc_offset":
                compareField(fieldName, expectedValue, weatherResponseModel.getLocation().getUtc_offset());
                break;
            case "temperature":
                compareField(fieldName, expectedValue, String.valueOf(weatherResponseModel.getCurrent().getTemperature()));
                break;
            case "pressure":
                compareField(fieldName, expectedValue, String.valueOf(weatherResponseModel.getCurrent().getPressure()));
                break;
        }
    }
    private static <T> void compareField(String fieldName, T expectedValue, T actualValue) {
        if (!expectedValue.equals(actualValue)) {
            logger.warn("Mismatch in {}: Expected: {}, Actual: {}", fieldName, expectedValue, actualValue);
        }
    }

}
