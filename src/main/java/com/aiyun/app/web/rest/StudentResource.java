package com.aiyun.app.web.rest;

import com.aiyun.app.domain.Student;
import com.aiyun.app.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final Logger logger = LoggerFactory.getLogger(StudentResource.class);

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @ApiOperation(value = "获取所有学生信息")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/students/{code}")
    @ApiOperation(value = "通过学号获取学生信息")
    public ResponseEntity<Student> findByCode(@PathVariable String code){
        logger.debug("获取学号为()的学生",code);
        try{
            Student student = studentService.findByCode(code);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取学生信息失败，失败信息是:{}",e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/students/search")
    @ApiOperation(value = "通过关键词检索学生列表")
    public ResponseEntity<List<Student>> findByKeyword(String keyword){
        List<Student> studentList = studentService.findByKeyword(keyword);
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/students/create")
    @ApiOperation(value = "创建学生")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PostMapping("/students/update")
    @ApiOperation(value = "修改学生信息",notes = "通过输入的学号修改对应学号的学生信息")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/students/delete")
    @ApiOperation(value = "通过学号删除学生")
    public ResponseEntity<String> deleteStudent(String code){
        studentService.deleteStudent(code);
        return ResponseEntity.ok("删除成功");
    }
}
