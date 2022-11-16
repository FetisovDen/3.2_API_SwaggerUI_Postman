package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.model.StudentsByCategory;
import pro.sky.apiSwagerPostman.hogwarts.service.StudentService;


import java.util.List;

@RestController
@RequestMapping("/student/category")
public class StudentsByCategoryController {

    private final StudentService studentService;

    public StudentsByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/count")
    public Integer getStudentByAge() {
        return studentService.countStudents();
    }
    @GetMapping("/avgAge")
    public Double avgAgeStudents() {
        return studentService.avgAgeStudents();
    }
    @GetMapping("/lastFiveStudents")
    public List<Student> lastFiveStudentsById() {
        return studentService.lastFiveStudentsById();
    }
}
