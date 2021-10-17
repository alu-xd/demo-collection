package com.lulu.mybatis;

import com.lulu.mybatis.repo.StudentScore;
import com.lulu.mybatis.repo.mapper.StudentScoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentScoreMapper mapper = sqlSession.getMapper(StudentScoreMapper.class);
            List<StudentScore> studentScores = mapper.selectByName("zhangsan");

            for (StudentScore studentScore : studentScores) {
                System.out.println("name=" + studentScore.getName());
            }
        }
    }
}

