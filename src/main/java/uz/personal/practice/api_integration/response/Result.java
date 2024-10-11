package uz.personal.practice.api_integration.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.personal.practice.api_integration.hemis.StudentHemis;

@Getter
@Setter
@NoArgsConstructor
public class Result {
    private String message;
    private Boolean status;
    private StudentHemis object;

    public Result(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
