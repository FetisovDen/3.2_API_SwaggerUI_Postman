package pro.sky.API_Swager_Postman.hogwarts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.API_Swager_Postman.hogwarts.Model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByAge(int age);
}
