package pro.sky.apiSwagerPostman.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);
    Collection<Faculty> findByColorOrNameIgnoreCase(String name,String color);

    Faculty findFacultyByStudentContaining(Student student);

}