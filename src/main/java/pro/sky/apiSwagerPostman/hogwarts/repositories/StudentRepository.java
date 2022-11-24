package pro.sky.apiSwagerPostman.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;
import pro.sky.apiSwagerPostman.hogwarts.model.StudentsByCategory;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);
    Collection<Student> findByFaculty_Id(Long id);

    @Query(value = "SELECT COUNT(id) as count FROM students", nativeQuery = true)
    Integer countStudents();
    @Query(value = "SELECT AVG(age) as avgAge FROM students", nativeQuery = true)
    Double avgAgeStudents();
    @Query(value = "SELECT * FROM students ORDER BY id OFFSET :count -5", nativeQuery = true)
    List<Student> lastFiveStudentsById(@Param("count") Integer count);

}
