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
public class MandatResponse {

    @JsonProperty("Result")
    private Double result;
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("Natija")
    private String natija;
    @JsonProperty("EducLanguageName")
    private String educLanguageName;
    @JsonProperty("FacultySName")
    private String facultySName;
    @JsonProperty("nBall1")
    private Double nBall1;
    @JsonProperty("nBall2")
    private Double nBall2;

    @JsonProperty("nBall3")
    private Double nBall3;
    @JsonProperty("nBall4")
    private Double nBall4;
    @JsonProperty("nBall5")
    private Double nBall5;
    @JsonProperty("s1Name")
    private String s1Name;
    @JsonProperty("s2Name")
    private String s2Name;

    @JsonProperty("s3Name")
    private String s3Name;
    @JsonProperty("s4Name")
    private String s4Name;
    @JsonProperty("s5Name")
    private String s5Name;

    @JsonProperty("UniversitySName")
    private String universitySName;


}