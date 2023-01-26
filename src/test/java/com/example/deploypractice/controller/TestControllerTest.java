package com.example.deploypractice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void deploy_테스트(){
        ResponseEntity<String> response = restTemplate.getForEntity("/deploy/test", String.class);
        assertEquals("<h1>deploy test</h1>", response.getBody());
    }
}