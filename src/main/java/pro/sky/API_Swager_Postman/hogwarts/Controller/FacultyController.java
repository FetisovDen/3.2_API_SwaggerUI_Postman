package pro.sky.API_Swager_Postman.hogwarts.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.API_Swager_Postman.hogwarts.Model.Faculty;
import pro.sky.API_Swager_Postman.hogwarts.Service.FacultyService;

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
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
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
        if (faculties == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }

    @DeleteMapping()
    public  ResponseEntity<Faculty> deleteFaculty(@RequestBody Faculty faculty) {
        facultyService.deleteFaculty(faculty.getId());
        return ResponseEntity.ok(faculty);
    }
}

