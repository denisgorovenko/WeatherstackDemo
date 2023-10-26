package api;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiErrorResponseModel {
    @JsonProperty("success")
    public boolean success;
    @JsonProperty("error")
    public Error error;

    @Data
    public static class Error {

        @JsonProperty("code")
        public int code;
        @JsonProperty("type")
        public String type;
        @JsonProperty("info")
        public String info;

    }
}
