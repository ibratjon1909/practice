package uz.personal.practice.api_integration.hemis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentHemisInfoResponse {
    private String message;
    private boolean status;
    private StudentHemis object;
}
