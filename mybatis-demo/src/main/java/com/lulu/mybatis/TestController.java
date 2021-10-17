package com.lulu.mybatis;

import com.google.gson.Gson;
import com.lulu.mybatis.repo.StudentScore;
import com.lulu.mybatis.repo.mapper.StudentScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private StudentScoreMapper mapper;

    @GetMapping(path = "/demo")
    public String handle() {
        List<StudentScore> studentScores = mapper.selectAll();

        if (!CollectionUtils.isEmpty(studentScores)) {
            studentScores.forEach(item -> {
                System.out.println(new Gson().toJson(item));
            });
        }else{
            System.out.println("result is empty");
        }
        return "hello";
    }
}
