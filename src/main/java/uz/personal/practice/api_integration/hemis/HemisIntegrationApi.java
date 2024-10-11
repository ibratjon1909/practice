
package uz.personal.practice.api_integration.hemis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uz.personal.practice.api_integration.ApiConstant;
import uz.personal.practice.api_integration.LoginRequest;
import uz.personal.practice.api_integration.response.Result;
import uz.personal.practice.domain.TokenEntity;
import uz.personal.practice.repository.TokenEntityRepository;

import java.util.List;
import java.util.Optional;

import static uz.personal.practice.api_integration.ApiConstant.HEMIS_INTEGRATION_API_PASSWORD;
import static uz.personal.practice.api_integration.ApiConstant.HEMIS_INTEGRATION_API_USERNAME;

@Service
@RequiredArgsConstructor
public class HemisIntegrationApi {

    private static final String UNIVERSITY_URL = "https://student.hemis.uz/rest/v1/public/university-list";
    private final WebClient webClient;
    private final TokenEntityRepository tokenEntityRepository;


    public HamisIntegrationTokenResponse getTokenFromHemisIntegration() {
        Optional<TokenEntity> hemisToken = tokenEntityRepository.findByOrgName("hemis_integration");
        if (hemisToken.get().getEndTime() < System.currentTimeMillis()) {
            HamisIntegrationTokenResponse tokenResponse = webClient.post()
                    .uri(ApiConstant.HEMIS_INTEGRATION_API_URL)
                    .bodyValue(new LoginRequest(HEMIS_INTEGRATION_API_USERNAME, HEMIS_INTEGRATION_API_PASSWORD))
                    .retrieve()
                    .onStatus(HttpStatus.BAD_GATEWAY::equals, response -> Mono.empty())
                    .bodyToMono(HamisIntegrationTokenResponse.class)
                    .block();
            if (tokenResponse == null) {
                return null;
            }
            hemisToken.get().setToken(tokenResponse.getToken());
            hemisToken.get().setEndTime(tokenResponse.getExpired());
            tokenEntityRepository.save(hemisToken.get());
            return tokenResponse;
        } else {
            return new HamisIntegrationTokenResponse(hemisToken.get());
        }
    }

    public StudentHemisInfoResponse getStudentInfo(String pinfl, Integer eduYearCode) {
        return webClient.get()
                .uri("https://172.18.8.11:8888/api/studentInfo/" + pinfl + "/" + eduYearCode)
                .headers(h -> h.setBearerAuth(getTokenFromHemisIntegration().getToken()))
                .retrieve()
                .bodyToMono(StudentHemisInfoResponse.class)
                .block();
    }

    public List<StudentHemis> getAllStudentsByUniversityCode(String universityCode, Integer eduYearCode) {
        return webClient.get()
                .uri("https://api.hemis.uz/api/student/allByUniversityCode/" + universityCode + "/" + eduYearCode)
                .headers(h -> h.setBearerAuth(getTokenFromHemisIntegration().getToken()))
                .retrieve()
                .bodyToFlux(StudentHemis.class)
                .collectList()
                .block();
    }

    //lyuboy statusdagi talabani olish
    public StudentHemisInfoResponse getStudentInfoByPinflAndAllStatus(String pinfl, Integer eduYearCode) {
        return webClient.get()
                .uri("https://api.hemis.uz/api/studentInfo/byPinflAndEduYearCode/" + pinfl + "/" + eduYearCode)
                .headers(h -> h.setBearerAuth(getTokenFromHemisIntegration().getToken()))
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, response -> Mono.empty())
                .bodyToMono(StudentHemisInfoResponse.class)
                .block();
    }

    //lyuboy statusdagi talabani olish
    public StudentHemisInfoResponse studentInfoByPinflTemporary(String pinfl) {
        return webClient.get()
                .uri("https://localhost:8888/api/studentInfoByPinflTemporary/" + pinfl)
//                .headers(h -> h.setBearerAuth(getTokenFromHemisIntegration().getToken()))
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, response -> Mono.empty())
                .bodyToMono(StudentHemisInfoResponse.class)
                .block();
    }
}