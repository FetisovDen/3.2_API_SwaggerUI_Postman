package pro.sky.API_Swager_Postman.hogwarts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.API_Swager_Postman.hogwarts.Model.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);

    boolean countFacultiesById(Faculty faculty);
}