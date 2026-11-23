package com.learning.external_api_intergration.contoller;

import com.learning.external_api_intergration.dto.*;
import com.learning.external_api_intergration.service.ExternalUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class ExternalUserController {
    private final ExternalUserService externalUserService;

    public ExternalUserController (ExternalUserService externalUserService){
        this.externalUserService = externalUserService;
    }

    @GetMapping("/users")
    public List<ExternalUser> getAllUsers(){
        return externalUserService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public ExternalUser getUserById(@PathVariable Long id){
        return externalUserService.getUserById(id);
    }
    @GetMapping("/posts")
    public List<ExternalPost> getPostsByUserId(@RequestParam Long userId){
        return externalUserService.getPostsByUserId(userId);
    }
    @PostMapping("/posts")
    public ExternalPost createPost(@RequestBody ExternalPostRequest postRequest){
        return externalUserService.createPost(postRequest);
    }

    @PostMapping("/auth/login")
    public ExtAuthLoginResponse login(@RequestBody ExtAuthLoginRequest loginRequest){
        System.out.println("Username received: " + loginRequest.username());
        return externalUserService.login(loginRequest);
    }
    @GetMapping("auth/me")
    public ExtAuthenticatedUser getAuthenticatedUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        return externalUserService.getAuthenticatedUser(authorizationHeader);
    }

}
