package com.lulu.mybatis;

import com.lulu.mybatis.repo.StudentScore;
import com.lulu.mybatis.repo.mapper.StudentScoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class BasicFunctionTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp(){
        if(Objects.nonNull(sqlSessionFactory)){
            return;
        }

        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public  void test() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentScoreMapper mapper = sqlSession.getMapper(StudentScoreMapper.class);
            List<StudentScore> studentScores = mapper.selectAll();

            for (StudentScore studentScore : studentScores) {
                System.out.println("name=" + studentScore.getName());
            }
        }
    }
}
