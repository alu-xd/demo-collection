package com.lulu.mybatis.service;

import com.google.gson.Gson;
import com.lulu.mybatis.repo.StudentScore;
import com.lulu.mybatis.repo.mapper.StudentScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreMapper mapper;

    @Transactional
    public void showScore() {
        List<StudentScore> studentScores = mapper.selectAll();

        if (!CollectionUtils.isEmpty(studentScores)) {
            studentScores.forEach(item -> {
                System.out.println(new Gson().toJson(item));
            });
        } else {
            System.out.println("result is empty");
        }
    }
}
