package com.lulu.mybatis;

import com.lulu.mybatis.repo.mapper.StudentScoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class PluginTest {
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
    public  void testUpdate() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentScoreMapper mapper = sqlSession.getMapper(StudentScoreMapper.class);
            int result = mapper.updateScore("zhangsan", 100);
            System.out.println("update result: "+result);;
            assertEquals(1, result);
        }
    }

    @Test
    public  void testMutilParamUpdate() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentScoreMapper mapper = sqlSession.getMapper(StudentScoreMapper.class);
            int result = mapper.updateScoreByNameClassNo("zhangsan","01", 100);
            System.out.println("update result: "+result);;
            assertEquals(1, result);
        }
    }
}
