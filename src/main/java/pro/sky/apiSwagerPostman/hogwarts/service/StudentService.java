package pro.sky.apiSwagerPostman.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.repositories.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(AvatarService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(long id) {
        logger.info("Was invoked method for get student by id");
        logger.error("There is not student with id = " + id);
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Такого студента не существует!"));

    }

    public Student updateStudent(Student student) {
        logger.info("Was invoked method for update student");
        studentRepository.findById(student.getId()).orElseThrow(() -> new NotFoundException("Такого студента не существует!"));
        logger.error("There is not student with id = " + student.getId());
        studentRepository.save(student);
        return student;
    }

    public Collection<Student> getStudentsByAge(int age) {
        logger.info("Was invoked method for get student by age");
        return studentRepository.findByAge(age);
    }

    public void deleteStudent(long id) {
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for find student by age between min and max");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<Student> findStudentsByFaculty(long id) {
        logger.info("Was invoked method for find students by faculty");
        return studentRepository.findByFaculty_Id(id);
    }

    public Integer countStudents() {
        logger.info("Was invoked method for count students");
        return studentRepository.countStudents();

    }

    public Double avgAgeStudents() {
        logger.info("Was invoked method for find average age of students");
        return studentRepository.avgAgeStudents();
    }

    public List<Student> lastFiveStudentsById() {
        logger.info("Was invoked method for find last five students by id");
        Integer count = studentRepository.countStudents();
        if (count < 5) {
            count = 5;
        }
        return studentRepository.lastFiveStudentsById(count);
    }

}

