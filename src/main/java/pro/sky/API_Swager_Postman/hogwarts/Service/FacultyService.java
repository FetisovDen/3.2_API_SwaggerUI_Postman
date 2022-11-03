package pro.sky.API_Swager_Postman.hogwarts.Service;

import org.springframework.stereotype.Service;
import pro.sky.API_Swager_Postman.hogwarts.Model.Faculty;
import pro.sky.API_Swager_Postman.hogwarts.Repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }

    public Faculty getFacultyById(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (facultyRepository.countFacultiesById(faculty)){
            throw new RuntimeException("такого факультета нет");
        }
        else {facultyRepository.save(faculty);
        return faculty;}
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
}
