package com.learning.external_api_intergration.service;

import com.learning.external_api_intergration.dto.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

//The actual external API communication
@Service
public class ExternalUserService {
    private final RestClient restClient;
    private final RestClient dummyJsonClient;

    public ExternalUserService (RestClient.Builder restClientBuilder){
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com") //base address ofthe external API
                .build();

        this.dummyJsonClient = restClientBuilder
                .baseUrl("https://dummyjson.com")
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
    public ExternalPost createPost(ExternalPostRequest postRequest){
        return restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(postRequest) //sending the actual data ie. passing Java abject into the request body
                .retrieve()
                .body(ExternalPost.class);
    }
    //the Authentication methods to DummyJson
    public ExtAuthLoginResponse login(ExtAuthLoginRequest loginRequest){
        return dummyJsonClient.post()
                .uri("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(loginRequest) //sends the username and password
                .retrieve()
                .body(ExtAuthLoginResponse.class); //conversion from JSON to Java object
    }
    public ExtAuthenticatedUser getAuthenticatedUser(String authorizationHeader){
        return dummyJsonClient.get()
                .uri("/auth/me")
                .header(HttpHeaders.AUTHORIZATION, authorizationHeader) //passing the authorisation header to dummyjson api
                .retrieve()
                .body(ExtAuthenticatedUser.class);
    }

}
