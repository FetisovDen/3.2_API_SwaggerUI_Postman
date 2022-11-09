package pro.sky.apiSwagerPostman.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.apiSwagerPostman.hogwarts.model.Faculty;

import java.util.Collection;
import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColorIgnoreCase(String color);
    Collection<Faculty> findByColorOrNameIgnoreCase(String name,String color);
    Faculty findFacultyByStudentId(Long id);

}