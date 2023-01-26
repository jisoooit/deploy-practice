package com.example.deploypractice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/deploy/test")
    public String hello(@RequestParam(defaultValue = "1") Integer number){
        if(number == 1){ // info 로그
            log.info("/deploy/test 이 호출되었어요. info 로그 #####################################");
        }else if(number == -1){ // error 로그
            log.error("/deploy/test 이 호출되었어요. error 로그 #####################################");
        }else if(number == 0){ // warn 로그
            log.warn("/deploy/test 이 호출되었어요. warn 로그 #####################################");
        }

        return "<h1>deploy test</h1>";
    }
}
