package pro.sky.ApiSwagerPostman.hogwarts.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.ApiSwagerPostman.hogwarts.model.Student;
import pro.sky.ApiSwagerPostman.hogwarts.repositories.StudentRepository;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(()->new NotFoundException("Такого индификатора не существует!"));
    }

    public Student updateStudent(Student student) {
        studentRepository.findById(student.getId()).orElseThrow(()->new NotFoundException("Такого студента не существует!"));
        studentRepository.save(student);
        return student;
    }
    public List<Student> getStudentsByAge (int age) {
        return studentRepository.findByAge(age);
    }
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}

