package com.aiyun.app.service.impl;

import com.aiyun.app.domain.Student;
import com.aiyun.app.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    /**
     * 学生列表
     */
    public static List<Student> studentList = new ArrayList<>();

    public static void init(){
        studentList.add(new Student("001","一号","一班","一年级"));
        studentList.add(new Student("002","二号","一班","一年级"));
        studentList.add(new Student("003","三号","二班","二年级"));
        studentList.add(new Student("004","四号","二班","二年级"));
        studentList.add(new Student("005","五号","三班","三年级"));
    }

    /**
     * 获取所有学生列表
     * @return
     */
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    /**
     *通过关键词检索学生列表
     * @param keyword
     * @return
     */
    @Override
    public List<Student> findByKeyword(String keyword) {
        List<Student> studentList = StudentServiceImpl.studentList.stream()
            .filter(student ->
                keyword.equals(student.getCode()) ||
                keyword.equals(student.getName()) ||
                keyword.equals(student.getClassName()) ||
                keyword.equals(student.getGrade())).collect(Collectors.toList());
        return studentList;
    }

    /**
     * 通过学号获取学生信息
     * @param code
     * @return
     */
    @Override
    public Student findByCode(String code) throws Exception{
        List<Student> students = studentList.stream().
            filter(student -> code.equals(student.getCode()))
            .collect(Collectors.toList());
        if (students.isEmpty()){
            throw new Exception("不存在该学号的学生");
        }
        return students.get(0);
    }

    /**
     * 创建学生
     * @param student
     * @return
     */
    @Override
    public Student createStudent(Student student) {
        if (student.getCode() == null ||
            student.getName() == null ||
            student.getClassName() == null ||
            student.getGrade() == null){
            throw new RuntimeException("缺少信息");
        }
        studentList.add(student);
        return student;
    }

    /**
     * 通过输入的学号修改对应学号的学生信息
     * @param student
     * @return
     */
    @Override
    public Student updateStudent(Student student) {
        List<Student> studentList = StudentServiceImpl.studentList.stream()
            .filter(student1 -> student1.getCode().equals(student.getCode())).collect(Collectors.toList());
        if (studentList.isEmpty()){
            throw new RuntimeException("不存在该学号");
        }
        Student student1 = studentList.get(0);
        student1.setCode(student.getCode());
        student1.setName(student.getName());
        student1.setClassName(student.getClassName());
        student1.setGrade(student.getGrade());
        return student1;
    }

    /**
     * 通过学号删除学生
     * @param code
     */
    @Override
    public void deleteStudent(String code) {
        List<Student> list = studentList.stream()
            .filter(student -> code.equals(student.getCode()))
            .collect(Collectors.toList());
        if (list.isEmpty()){
            throw new RuntimeException("不存在该学号");
        }
        studentList.removeAll(list);
    }
}
