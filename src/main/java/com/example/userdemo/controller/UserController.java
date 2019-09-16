package com.example.userdemo.controller;

import com.example.userdemo.dto.UserListRspDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    private static String RESOURCE_URL = "https://jsonplaceholder.typicode.com/users";
    private RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/user-list")
    public List<UserListRspDTO> getUpdatedUserList() {
        ResponseEntity<List<UserListRspDTO>> response = restTemplate.exchange(
                RESOURCE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserListRspDTO>>() {});

        return response.getBody();
    }
}
