package pro.sky.apiSwagerPostman.hogwarts.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.repositories.FacultyRepository;

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

    public Collection<Faculty> getFacultyByColorOrName(String color, String name) {
        return facultyRepository.findByColorOrNameIgnoreCase(color,name);
    }

    public Faculty getFacultyByStudent(Student student){
        return facultyRepository.findFacultyByStudentContaining(student);
    }

}

