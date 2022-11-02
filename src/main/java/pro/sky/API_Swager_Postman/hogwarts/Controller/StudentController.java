package pro.sky.API_Swager_Postman.hogwarts.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.API_Swager_Postman.hogwarts.Model.Student;
import pro.sky.API_Swager_Postman.hogwarts.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{Id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long Id) {
        Student student = studentService.getStudentById(Id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("{age}")
    public ResponseEntity<List<Student>> getStudent(@PathVariable int age) {
        List<Student> student = studentService.getStudentsByAge(age);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping()
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        Student deleteStudent = studentService.deleteStudent(student.getId());
        return ResponseEntity.ok(deleteStudent);
    }
}
