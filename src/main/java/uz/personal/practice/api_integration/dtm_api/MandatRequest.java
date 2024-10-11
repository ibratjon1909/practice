package uz.personal.practice.api_integration.dtm_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MandatRequest {

    @JsonProperty("pinfl")
    private String pinfl;

    @JsonProperty("pas_ser")
    private String pasSer;

    @JsonProperty("year")
    private String year;
}