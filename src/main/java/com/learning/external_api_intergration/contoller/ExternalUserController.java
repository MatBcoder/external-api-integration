package com.learning.external_api_intergration.contoller;

import com.learning.external_api_intergration.dto.ExternalUser;
import com.learning.external_api_intergration.service.ExternalUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
