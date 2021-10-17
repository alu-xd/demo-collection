package com.lulu.mybatis;

import com.lulu.mybatis.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @Autowired
    private StudentScoreService studentScoreService;

    @GetMapping(path = "/demo")
    public String handle() {

        studentScoreService.showScore();
        return "hello";
    }
}
