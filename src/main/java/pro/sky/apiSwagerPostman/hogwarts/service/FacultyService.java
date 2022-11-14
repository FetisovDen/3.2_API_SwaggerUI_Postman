package pro.sky.apiSwagerPostman.hogwarts.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.apiSwagerPostman.hogwarts.repositories.FacultyRepository;
import pro.sky.apiSwagerPostman.hogwarts.repositories.StudentRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository,StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }

    public Faculty getFacultyById(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Такого факультета не существует!"));
    }

    public Faculty updateFaculty(Faculty faculty) {
        facultyRepository.findById(faculty.getId()).orElseThrow(() -> new NotFoundException("Такого факультета не существует!"));
        facultyRepository.save(faculty);
        return faculty;
    }


    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultyByColorOrName(String nameOrColor) {
        return facultyRepository.findByColorOrNameIgnoreCase(nameOrColor,nameOrColor);
    }

    public Faculty getFacultyByStudent(long id){
        return facultyRepository.findFacultyByStudentId(id);
    }

}

