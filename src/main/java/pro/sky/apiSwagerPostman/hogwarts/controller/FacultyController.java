package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.service.FacultyService;
import pro.sky.apiSwagerPostman.hogwarts.service.StudentService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;
    private final StudentService studentService;

    public FacultyController(FacultyService facultyService,StudentService studentService) {
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createUser(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty>  getFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity<Faculty>  updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @GetMapping()
    public ResponseEntity<Collection<Faculty>>  getFacultiesByColor(@RequestParam String color) {
        Collection<Faculty> faculties = facultyService.getFacultyByColor(color);
        return ResponseEntity.ok(faculties);
    }

    @DeleteMapping("/{facultyId}")
    public  ResponseEntity<Faculty> deleteFaculty(@PathVariable long facultyId) {
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findByColorOrName")
    public ResponseEntity<Collection<Faculty>>  getFacultiesByColorOrName(@RequestParam String nameOrColor) {
        Collection<Faculty> faculties = facultyService.getFacultyByColorOrName(nameOrColor);
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<Collection<Student>> findStudentsByFaculty(@PathVariable("id") long id) {
        Collection<Student> students = studentService.findStudentsByFaculty(id);
        return ResponseEntity.ok(students);
    }


}


