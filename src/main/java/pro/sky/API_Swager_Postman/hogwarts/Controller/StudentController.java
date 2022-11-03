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
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudent(@RequestParam int age) {
        List<Student> student = studentService.getStudentsByAge(age);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping()
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student.getId());
        return ResponseEntity.ok(student);
    }
}
