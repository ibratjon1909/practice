package uz.personal.practice.api_integration.dtm_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.personal.practice.domain.TokenEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTMTokenResponse{

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("refresh_token")
	private String refreshToken;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("expires_in")
	private Integer expiresIn;
	public DTMTokenResponse(TokenEntity tokenEntity) {
		this.accessToken = tokenEntity.getToken();
	}
}