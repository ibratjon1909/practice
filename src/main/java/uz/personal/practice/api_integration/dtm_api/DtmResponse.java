package uz.personal.practice.api_integration.dtm_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtmResponse {
    @JsonProperty("status")
    private int status;
    @JsonProperty("Data")
    private MandatResponse mandatResponse;
}
