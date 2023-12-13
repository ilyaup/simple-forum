package integration;

import forum.ilya.Application;
import forum.ilya.core.service.user.db.UserRepository;
import forum.ilya.rest.user.RegisterRequest;
import forum.ilya.rest.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class,
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:///forum",
                "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
        })
public class RegistrationTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void requestRegisterUsers_test1() {
        RegisterRequest registerRequest1 = new RegisterRequest("ilya", "1234", "a@mail.ru");
        RegisterRequest registerRequest2 = new RegisterRequest("vanya", "1111", "abc@mail.ru");
        RegisterRequest registerRequest3 = new RegisterRequest("anya", "qwerty", "efg@mail.ru");
        userController.register(registerRequest1);
        userController.register(registerRequest2);
        userController.register(registerRequest3);
        assertEquals(3, userRepository.findAll().size());
    }
}
