package pro.sky.apiSwagerPostman.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(AvatarService.class);

    public FacultyService(FacultyRepository facultyRepository,StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for save faculty");
        facultyRepository.save(faculty);
        return faculty;
    }

    public Faculty getFacultyById(long id) {
        logger.info("Was invoked method for get faculty by id");
        logger.error("There is not faculty with id = " + id);
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Такого факультета не существует!"));
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        facultyRepository.findById(faculty.getId()).orElseThrow(() -> new NotFoundException("Такого факультета не существует!"));
        logger.error("There is not faculty with id = " + faculty.getId());
        facultyRepository.save(faculty);
        return faculty;
    }


    public Collection<Faculty> getFacultyByColor(String color) {
        logger.info("Was invoked method for get faculty by color");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public void deleteFaculty(long id) {
        logger.info("Was invoked method for delete faculty");
        logger.debug("It is necessary to output error information if the id is not found");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultyByColorOrName(String nameOrColor) {
        logger.info("Was invoked method for get faculty by color or name");
        return facultyRepository.findByColorOrNameIgnoreCase(nameOrColor,nameOrColor);
    }

    public Faculty getFacultyByStudent(long id){
        logger.info("Was invoked method for get faculty by student");
        return facultyRepository.findFacultyByStudentId(id);
    }

}

