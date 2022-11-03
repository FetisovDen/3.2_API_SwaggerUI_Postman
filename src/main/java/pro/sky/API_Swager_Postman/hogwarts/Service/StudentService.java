package pro.sky.API_Swager_Postman.hogwarts.Service;

import org.springframework.stereotype.Service;
import pro.sky.API_Swager_Postman.hogwarts.Model.Student;
import pro.sky.API_Swager_Postman.hogwarts.Repositories.StudentRepository;

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
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
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

