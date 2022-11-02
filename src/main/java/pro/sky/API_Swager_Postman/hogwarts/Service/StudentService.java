package pro.sky.API_Swager_Postman.hogwarts.Service;

import org.springframework.stereotype.Service;
import pro.sky.API_Swager_Postman.hogwarts.Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map <Long,Student> students = new HashMap<>();
    private Long generatedStudentId = 0L;

    public Student createStudent(Student student) {
        student.setId(generatedStudentId++);
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudentById(Long Id) {
        return students.get(Id);
    }

    public Student updateStudent(Long Id, Student student) {
        students.put(Id, student);
        return student;
    }
    public List<Student> getStudentsByAge (int age) {
        return students.values().stream().filter(f -> f.getId()== age).collect(Collectors.toList());
    }
    public Student deleteStudent(Long Id) {
        return students.remove(Id);
    }
}

