package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
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
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam int age) {
        List<Student> student = studentService.getStudentsByAge(age);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping()
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student.getId());
        return ResponseEntity.ok(student);
    }
    @GetMapping("/age_between")
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int min,
                                                                @RequestParam int max) {
        Collection<Student> student = studentService.findByAgeBetween(min,max);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/studentsByFacultyId/{id}")
    public ResponseEntity<Collection<Student>> findStudentsByFaculty(@PathVariable("id") long id) {
        Collection<Student> students = studentService.findStudentsByFaculty(id);
        return ResponseEntity.ok(students);
    }
}
