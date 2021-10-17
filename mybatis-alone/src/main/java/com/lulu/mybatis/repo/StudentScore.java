package com.lulu.mybatis.repo;

import java.time.LocalDate;

public class StudentScore {
    private int id;
    private String name;
    private String classNo;
    private String score;
    private String semester;
    private LocalDate createdDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNo() {
        return classNo;
    }

    public String getScore() {
        return score;
    }

    public String getSemester() {
        return semester;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
