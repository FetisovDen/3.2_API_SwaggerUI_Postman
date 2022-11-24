package pro.sky.apiSwagerPostman.hogwarts.model;


import org.springframework.stereotype.Component;

@Component
public interface StudentsByCategory {
    Integer countStudents();
    Integer avgAgeStudents();
    String lastFiveStudentsById();

}
