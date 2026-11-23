package com.learning.external_api_intergration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record ExtAuthenticatedUser(Long id, String username, String email, String firstName, String lastName) {
}
