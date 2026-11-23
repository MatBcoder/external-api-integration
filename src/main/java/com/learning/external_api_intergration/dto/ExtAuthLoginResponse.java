package com.learning.external_api_intergration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExtAuthLoginResponse(Long id, String username, String accessToken, String refreshToken) {
}
