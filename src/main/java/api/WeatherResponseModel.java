package api;


import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class WeatherResponseModel {

    @JsonProperty("request")
    private   Request request;

    @JsonProperty("location")
    private  Location location;

    @JsonProperty("current")
    private  Current current;

    @Data
    public static class Request {

        @JsonProperty("type")
        public String type;

        @JsonProperty("query")
        public String query;

        @JsonProperty("language")
        public String language;

        @JsonProperty("unit")
        public String unit;

    }
    @Data
    public static class Location {

        @JsonProperty("name")
        public String name;

        @JsonProperty("country")
        public String country;

        @JsonProperty("region")
        public String region;

        @JsonProperty("lat")
        public String lat;

        @JsonProperty("lon")
        public String lon;

        @JsonProperty("timezone_id")
        public String timezone_id;

        @JsonProperty("localtime")
        public String localtime;

        @JsonProperty("localtime_epoch")
        public String localtime_epoch;

        @JsonProperty("utc_offset")
        public String utc_offset;

    }

    @Data
    public static class Current {
        @JsonProperty("observation_time")
        public String observationTime;

        @JsonProperty("temperature")
        public int temperature;

        @JsonProperty("weather_code")
        public int weatherCode;

        @JsonProperty("weather_icons")
        public String[] weatherIcons;

        @JsonProperty("weather_descriptions")
        public String[] weatherDescriptions;

        @JsonProperty("wind_speed")
        public int windSpeed;

        @JsonProperty("wind_degree")
        public int windDegree;

        @JsonProperty("wind_dir")
        private String windDirection;

        @JsonProperty("pressure")
        public int pressure;

        @JsonProperty("precip")
        public int precip;

        @JsonProperty("humidity")
        public int humidity;

        @JsonProperty("cloudcover")
        public int cloudcover;

        @JsonProperty("feelslike")
        public int feelslike;

        @JsonProperty("uv_index")
        public int uvIndex;

        @JsonProperty("visibility")
        public int visibility;

        @JsonProperty("is_day")
        public String isDay;
    }

}
