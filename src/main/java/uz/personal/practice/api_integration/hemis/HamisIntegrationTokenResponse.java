package uz.personal.practice.api_integration.hemis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.personal.practice.domain.TokenEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HamisIntegrationTokenResponse {
    private String token;
    private String username;
    private Long expired;

    public HamisIntegrationTokenResponse(TokenEntity tokenEntity) {
        this.token = tokenEntity.getToken();
    }

}
