package com.learning.external_api_intergration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record ExternalPost(Long userId, Long id, String title, String body) {
}
