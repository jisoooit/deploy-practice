package com.example.deploypractice.controller;

import com.example.deploypractice.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestRepository todoRepository;
    @GetMapping("/deploy/test")
    public String hello(@RequestParam(defaultValue = "1") Integer number){
        if(number == 1){
            log.info("/deploy/test 이 호출되었어요. info 로그 #####################################");
        }else if(number == -1){
            log.error("/deploy/test 이 호출되었어요. error 로그 #####################################");
        }else if(number == 0){
            log.warn("/deploy/test 이 호출되었어요. warn 로그 #####################################");
        }

        return "<h1>deploy test!</h1>"+ todoRepository.findById(1L);
    }
}
