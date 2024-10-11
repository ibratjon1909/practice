package uz.personal.practice.api_integration.dtm_api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import uz.personal.practice.domain.TokenEntity;
import uz.personal.practice.repository.TokenEntityRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DTMServiceApi {
    private final WebClient webClient;
    private final TokenEntityRepository tokenEntityRepository;

    public DtmResponse getMandat(MandatRequest request) {
        return webClient.post()
                .uri("https://apimgw.egov.uz:8243/dtm/service/mandat/v1")
                .headers(httpHeader -> httpHeader.setBearerAuth(getIskmToken().getAccessToken()))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DtmResponse.class).block();
    }

    public IskmTokenResponse getIskmToken() {

        Optional<TokenEntity> dtmToken = tokenEntityRepository.findByOrgName("iskm");
        if (dtmToken.isPresent()) {
            if (dtmToken.get().getEndTime() < System.currentTimeMillis()) {
                IskmTokenResponse tokenResponse = getIskmTokenResponse();
                assert tokenResponse != null;
                dtmToken.get().setToken(tokenResponse.getAccessToken());
                dtmToken.get().setEndTime(System.currentTimeMillis() + 3000000);
                tokenEntityRepository.save(dtmToken.get());
                return tokenResponse;
            } else {
                return new IskmTokenResponse(dtmToken.get());
            }
        }

        IskmTokenResponse tokenResponse = getIskmTokenResponse();
        assert tokenResponse != null;
        TokenEntity tokenEntity = new TokenEntity(tokenResponse.getExpiresIn(), "iskm", tokenResponse.getAccessToken());
        TokenEntity saveTokenEntity = tokenEntityRepository.save(tokenEntity);
        return new IskmTokenResponse(saveTokenEntity);
    }

    private IskmTokenResponse getIskmTokenResponse() {

        String grant_type = "password";
        String username = "minvuz_user1";
        String password = "m1nvuz!@#";

        return webClient.post()
                .uri("https://iskm.egov.uz:9444/oauth2/token")
                .attribute("grant_type", grant_type)
                .attribute("username", username)
                .attribute("password", password)
                .headers(httpHeader -> httpHeader.setBasicAuth("lfZJDHdJm9Sw7UNsI0uUJzLZp9Ea", "s3cJ2Q3t0zswsMNXzE6nIh3KV8Ua"))
                .bodyValue(new IskmTokenRequest())
                .retrieve()
                .bodyToMono(IskmTokenResponse.class)
                .block();
    }

}
