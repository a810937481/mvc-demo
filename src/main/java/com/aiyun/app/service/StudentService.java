package com.aiyun.app.service;

import com.aiyun.app.domain.Student;

import java.util.List;

/**
 * 学生服务
 */
public interface StudentService {

    /**
     * 获取所有学生列表
     * @return
     */
    List<Student> findAll();

    /**
     * 通关关键词检索学生列表
     * @param keyword
     * @return
     */
    List<Student> findByKeyword(String keyword);

    /**
     * 通过学号获取学生信息
     * @param code
     * @return
     */
    Student findByCode(String code) throws Exception;

    /**
     * 创建学生
     * @param student
     * @return
     */
    Student createStudent(Student student);

    /**
     * 编辑学生信息
     * @param student
     * @return
     */
    Student updateStudent(Student student);

    /**
     * 通过学号删除学生信息
     * @param code
     */
    void deleteStudent(String code);

}
