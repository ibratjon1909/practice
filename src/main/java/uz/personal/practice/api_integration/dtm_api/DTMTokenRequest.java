package uz.personal.practice.api_integration.dtm_api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTMTokenRequest {

    private String grant_type="password";
    private String username="minvuz_user1";
    private String password="m1nvuz!@#";
}

