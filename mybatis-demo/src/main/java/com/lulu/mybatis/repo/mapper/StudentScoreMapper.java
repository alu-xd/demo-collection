package com.lulu.mybatis.repo.mapper;


import com.lulu.mybatis.repo.StudentScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

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
}

