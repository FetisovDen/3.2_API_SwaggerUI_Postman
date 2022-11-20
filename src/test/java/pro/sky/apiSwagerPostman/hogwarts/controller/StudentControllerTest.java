package pro.sky.apiSwagerPostman.hogwarts.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import pro.sky.apiSwagerPostman.hogwarts.model.Student;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentTests {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private StudentController studentController;

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(2L);
        student.setAge(15);
        student.setName("Don");
        Assertions.assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isEqualTo("{\"id\":2,\"name\":\"Don\",\"age\":15}");
    }
    @Test
    public void testGetStudent() throws Exception {
        Student student = new Student();
        student.setId(2L);
        student.setAge(15);
        student.setName("Don");
        Assertions.assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isEqualTo("{\"id\":2,\"name\":\"Don\",\"age\":15}");
        Assertions.assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/"+ 1L, String.class))
                .isEqualTo("{\"id\":1,\"name\":\"Don\",\"age\":15}");
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setId(2L);
        student.setAge(15);
        student.setName("Don");
        Assertions.assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isEqualTo("{\"id\":2,\"name\":\"Don\",\"age\":15}");

        Student student1 = new Student();
        student1.setId(1L);
        student1.setAge(17);
        student1.setName("Mona");
        testRestTemplate.put("http://localhost:" + port + "/student", student1);

        Assertions.assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/"+ 1L, String.class))
                .isEqualTo("{\"id\":1,\"name\":\"Mona\",\"age\":17}");

    }
    @Test
    public void testGetStudentByAge() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setAge(17);
        student.setName("Don");
        Assertions.assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isEqualTo("{\"id\":1,\"name\":\"Don\",\"age\":17}");
        Assertions.assertThat(studentController.getStudentByAge(17))
                .isNotNull();
    }
    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setAge(17);
        student.setName("Don");
        Assertions.assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isEqualTo("{\"id\":1,\"name\":\"Don\",\"age\":17}");
        testRestTemplate.delete("http://localhost:" + port + "/student/"+ 1L, student, String.class);
        Assertions.assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/"+ 1L, String.class))
                .isNotNull();
    }



}