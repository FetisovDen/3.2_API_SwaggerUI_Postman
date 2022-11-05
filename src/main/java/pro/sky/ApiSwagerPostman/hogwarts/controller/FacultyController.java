package pro.sky.ApiSwagerPostman.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.ApiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.ApiSwagerPostman.hogwarts.service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
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

    @DeleteMapping()
    public  ResponseEntity<Faculty> deleteFaculty(@RequestBody Faculty faculty) {
        facultyService.deleteFaculty(faculty.getId());
        return ResponseEntity.ok(faculty);
    }
}

