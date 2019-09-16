package com.example.userdemo.configuration;

import com.example.userdemo.dto.UserListRspDTO;
import com.example.userdemo.mapper.UserMapper;
import com.example.userdemo.model.User;
import com.example.userdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApplicationBootstrapper {
    private UserMapper userMapper;

    public ApplicationBootstrapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//    @Bean
//    public RestTemplate restTemplateInit() {
//        return new RestTemplate();
//    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, RestTemplate restTemplate) {
        String RESOURCE_URL = "https://jsonplaceholder.typicode.com/users";

        return (args) -> {
            ResponseEntity<List<UserListRspDTO>> response = restTemplate.exchange(
                    RESOURCE_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UserListRspDTO>>() {});

            List<UserListRspDTO> responseBody = response.getBody();

            User user = userMapper.userDTOToEntity(responseBody.get(0));

            System.out.println("this is: " + user.getName());
        };
    }
}
