package com.aiyun.app.service.impl;

import com.aiyun.app.domain.Student;
import com.aiyun.app.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoyuan
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * 学生列表
     */
    public static List<Student> studentList = new ArrayList<>();

    public static void init() {
        studentList.add(new Student("1", "学生1", "班级1", "2016"));
        studentList.add(new Student("2", "学生2", "班级2", "2017"));
        studentList.add(new Student("3", "学生3", "班级1", "2016"));
        studentList.add(new Student("4", "学生4", "班级3", "2018"));
        studentList.add(new Student("5", "学生5", "班级4", "2018"));
    }

    /**
     * 获取所有学生列表
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    /**
     * 通过关键词检索学生列表
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Student> findByKeyword(String keyword) {
        List<Student> studentList = StudentServiceImpl.studentList.stream().filter(student ->
                keyword.equals(student.getCode())
                        || keyword.equals(student.getClassName())
                        || keyword.equals(student.getGrade())
                        || keyword.equals(student.getName()))
                .collect(Collectors.toList());
        return studentList;
    }

    /**
     * 通过学号获取学生信息
     *
     * @param code
     * @return
     */
    @Override
    public Student findByCode(String code) throws Exception {
        List<Student> students = studentList.stream().
                filter(student -> code.equals(student.getCode()))
                .collect(Collectors.toList());
        if (students.isEmpty()) {
            throw new Exception("不存在该学号的学生");
        }
        return students.get(0);
    }

    /**
     * 新建学生
     *
     * @param student
     * @return
     */
    @Override
    public Student createStudent(Student student) {
        if (student.getCode() == null
        || student.getClassName() == null
        || student.getGrade() == null
        || student.getName() == null) {
            throw new RuntimeException("缺少信息");
        }
        studentList.add(student);
        return student;
    }

    /**
     * 编辑学生信息
     *
     * @param student
     * @return
     */
    @Override
    public Student updateStudent(Student student) {
        List<Student> studentList = StudentServiceImpl.studentList.stream().
                filter(student1 -> student1.getCode().equals(student.getCode())).
                collect(Collectors.toList());
        if (studentList.isEmpty()) {
            throw new RuntimeException("该学生不存在");
        }
        Student student1 = studentList.get(0);
        student1.setClassName(student.getClassName());
        student1.setGrade(student.getGrade());
        student1.setName(student.getName());
        return student1;
    }

    /**
     * 通过学号删除学生信息
     *
     * @param code
     */
    @Override
    public void deleteStudent(String code) {
        List<Student> list = studentList.stream().filter(student ->
                code.equals(student.getCode())).
                collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new RuntimeException("该学生不存在");
        }
        studentList.removeAll(list);
    }
}
