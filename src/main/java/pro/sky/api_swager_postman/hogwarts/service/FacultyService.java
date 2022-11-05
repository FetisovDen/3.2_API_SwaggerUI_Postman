package pro.sky.api_swager_postman.hogwarts.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.api_swager_postman.hogwarts.model.Faculty;
import pro.sky.api_swager_postman.hogwarts.repositories.FacultyRepository;

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
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Такого индификатора не существует!"));
    }

    public Faculty updateFaculty(Faculty faculty) {
        facultyRepository.findById(faculty.getId()).orElseThrow(() -> new NotFoundException("Такого факультета не существует!"));
        facultyRepository.save(faculty);
        return faculty;
    }


    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
}
