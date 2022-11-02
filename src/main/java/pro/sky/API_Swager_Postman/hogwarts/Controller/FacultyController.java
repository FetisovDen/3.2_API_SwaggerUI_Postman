package pro.sky.API_Swager_Postman.hogwarts.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.API_Swager_Postman.hogwarts.Model.Faculty;
import pro.sky.API_Swager_Postman.hogwarts.Service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody Faculty faculty) {
        Faculty createdUser = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("{Id}")
    public ResponseEntity getFaculty(@PathVariable Long Id) {
        Faculty faculty = facultyService.getFacultyById(Id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @GetMapping("{color}")
    public ResponseEntity getFacultiesByColor(@PathVariable String color) {
        List<Faculty> faculties = facultyService.getFacultyByColor(color);
        if (faculties == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @DeleteMapping()
    public ResponseEntity deleteFaculty(@RequestBody Faculty faculty) {
        Faculty deleteFaculty = facultyService.deleteFaculty(faculty.getId());
        return ResponseEntity.ok(deleteFaculty);
    }
}

