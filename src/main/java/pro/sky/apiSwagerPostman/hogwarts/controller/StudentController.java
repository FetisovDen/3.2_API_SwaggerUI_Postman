package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.service.FacultyService;
import pro.sky.apiSwagerPostman.hogwarts.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final FacultyService facultyService;
    private final StudentService studentService;

    public StudentController(FacultyService facultyService,StudentService studentService) {
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping()
    public ResponseEntity<Collection<Student>> getStudentByAge(@RequestParam int age) {
        Collection<Student> student = studentService.getStudentsByAge(age);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/age_between")
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int min,
                                                                @RequestParam int max) {
        Collection<Student> student = studentService.findByAgeBetween(min,max);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/{id}/faculty")
    public ResponseEntity<Faculty> getFacultyByStudent(@PathVariable long id) {
        Faculty faculty = facultyService.getFacultyByStudent(id);
        return ResponseEntity.ok(faculty);
    }


}
