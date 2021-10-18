package com.lulu.mybatis.repo.mapper;


import com.lulu.mybatis.repo.StudentScore;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

//@Mapper
//@Repository
public interface StudentScoreMapper {

    @Select({
            "select * from student_score"
    })
    @Results(id = "all_column", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.INTEGER),
            @Result(column = "class_no", property = "classNo", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "semester", property = "semester", jdbcType = JdbcType.INTEGER),
            @Result(column = "created_date", property = "createdDate", jdbcType = JdbcType.DATE)
    })
    List<StudentScore> selectAll();

    @Select({
            "select * from student_score where name =#{name, jdbcType=VARCHAR}"
    })
    @ResultMap("all_column")
    List<StudentScore> selectByName(String name);

    @Select({
            "select * from student_score where class_no =#{classNo, jdbcType=VARCHAR}",
            "and score > #{score, jdbcType=VARCHAR}"
    })
    @ResultMap("all_column")
    List<StudentScore> selectByClassNoAndScore(@Param("classNo") String classNo, @Param("score") Integer score);

    @Update({
            "update student_score set score = #{score, jdbcType=INTEGER} where name = #{name, jdbcType=VARCHAR}"
    })
    int updateScore(@Param("name") String name, @Param("score") Integer score);

    @Update({
            "update student_score set score = #{score, jdbcType=INTEGER} where name = #{name, jdbcType=VARCHAR}",
            "and class_no =#{classNo, jdbcType=VARCHAR}"
    })
    int updateScoreByNameClassNo(@Param("name") String name, @Param("classNo")String classNo, @Param("score") Integer score);
}

