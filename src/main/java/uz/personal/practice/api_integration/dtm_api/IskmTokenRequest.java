package uz.personal.practice.api_integration.dtm_api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IskmTokenRequest {

    private String grant_type="password";
    private String username="minvuz_user1";
    private String password="m1nvuz!@#";
}

