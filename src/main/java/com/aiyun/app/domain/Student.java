package com.aiyun.app.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 学生模型
 * @author zhaoyuan
 */
public class Student {

    @ApiModelProperty(value = "学号", required = true)
    private String code;

    @ApiModelProperty(value = "学生姓名", required = true)
    private String name;

    @ApiModelProperty(value = "班级名称", required = true)
    private String className;

    @ApiModelProperty(value = "年级", required = true)
    private String grade;

    public Student() {
    }

    public Student(String code, String name, String className, String grade) {
        this.code = code;
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public Student setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Student setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public Student setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}
