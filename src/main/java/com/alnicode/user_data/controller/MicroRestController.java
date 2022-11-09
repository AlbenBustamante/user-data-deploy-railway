package com.alnicode.user_data.controller;

import com.alnicode.user_data.dto.json.UserDto;
import com.alnicode.user_data.dto.user.UserResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/microservices")
@RequiredArgsConstructor
public class MicroRestController {

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<UserResp[]> getAllUsers() throws URISyntaxException {
        final var uri = "http://localhost:8080/api/users";
        return restTemplate.getForEntity(new URI(uri), UserResp[].class);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAll() {
        final var url = "https://jsonplaceholder.typicode.com/users";
        final var users = restTemplate.getForObject(url, UserDto[].class);

        return ResponseEntity.ok(users != null ? Arrays.asList(users) : new ArrayList<>());
    }

}
