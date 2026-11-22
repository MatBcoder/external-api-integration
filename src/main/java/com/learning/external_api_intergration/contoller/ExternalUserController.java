package com.learning.external_api_intergration.contoller;

import com.learning.external_api_intergration.dto.ExternalPost;
import com.learning.external_api_intergration.dto.ExternalPostRequest;
import com.learning.external_api_intergration.dto.ExternalUser;
import com.learning.external_api_intergration.service.ExternalUserService;
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
}
