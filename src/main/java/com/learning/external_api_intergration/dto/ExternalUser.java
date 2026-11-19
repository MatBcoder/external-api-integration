package com.learning.external_api_intergration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Java representation of the external data (JSON data from JSONPLaceholder API)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalUser(Long id, String name, String username, String email) {
}
