package pro.sky.apiSwagerPostman.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student getById(Long id);
    List<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);

    Collection<Student> findByFaculty_Id(Long id);
}
