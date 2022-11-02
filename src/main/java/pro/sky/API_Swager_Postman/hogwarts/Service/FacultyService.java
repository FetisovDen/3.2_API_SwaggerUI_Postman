package pro.sky.API_Swager_Postman.hogwarts.Service;

import org.springframework.stereotype.Service;
import pro.sky.API_Swager_Postman.hogwarts.Model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(generatedFacultyId);
        faculties.put(faculty.getId(), faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long Id) {
        return faculties.get(Id);
    }

    public Faculty updateFaculty(Long Id, Faculty student) {
        faculties.put(Id, student);
        return student;
    }

    public List<Faculty> getFacultyByColor(String color) {
        return faculties.values().stream().filter(f -> f.getColor().equals(color)).collect(Collectors.toList());
    }

    public Faculty deleteFaculty(Long Id) {
        return faculties.remove(Id);
    }
}
