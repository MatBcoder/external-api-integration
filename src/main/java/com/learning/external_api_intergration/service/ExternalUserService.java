package com.learning.external_api_intergration.service;

import com.learning.external_api_intergration.dto.ExternalPost;
import com.learning.external_api_intergration.dto.ExternalUser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

//The actual external API communication
@Service
public class ExternalUserService {
    private final RestClient restClient;

    public ExternalUserService (RestClient.Builder restClientBuilder){
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com") //base address ofthe external API
                .build();

    }
    public List<ExternalUser> getAllUsers(){
        return restClient.get() //sending the Http request
                .uri("/users")
                .retrieve() //preparing to receive the response
                .body(new ParameterizedTypeReference<List<ExternalUser>>() {});//converting JSON into Java objects list

    }
    public ExternalUser getUserById(Long id){
        return restClient.get()
                .uri("/users/{id}", id) //URL pattern
                .retrieve()
                .body(ExternalUser.class);// only one user expected
    }
    public List<ExternalPost> getPostsByUserId(Long userId){
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/posts")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<ExternalPost>>() {
                });
    }
}
