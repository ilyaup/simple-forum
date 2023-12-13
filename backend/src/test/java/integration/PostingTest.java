package integration;

import forum.ilya.Application;
import forum.ilya.core.service.post.db.PostRepository;
import forum.ilya.core.service.user.db.UserAccount;
import forum.ilya.core.service.user.db.UserRepository;
import forum.ilya.rest.post.PostController;
import forum.ilya.rest.post.PostRequest;
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
public class PostingTest {

    @Autowired
    private PostController postController;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {

    }

    @Test
    void requestPost_test1() {
        long userId = userRepository.save(UserAccount.builder()
                .login("ilya")
                .password("qwer")
                .email("a@gmail.ru")
                .build()).getId();
        PostRequest postRequest = PostRequest.builder()
                .userId(userId)
                .content("Fish")
                .build();
        long postId = postController.createPost(postRequest);
        assertEquals(postRequest.content(), postRepository.getPostById(postId).orElseThrow().getContent());
    }
}
