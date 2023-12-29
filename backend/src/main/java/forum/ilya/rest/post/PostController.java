package forum.ilya.rest.post;

import forum.ilya.core.service.post.PostCreatorService;
import forum.ilya.core.service.post.db.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@Slf4j
public class PostController {

    private final PostCreatorService postCreatorService;
    private final PostService postService;
    private final PostMapper postMapper;

    @PostMapping(path = "create_post")
    public long createPost(@RequestBody PostRequest postRequest) {
        log.info(postRequest.toString());
        return postCreatorService.createPost(postMapper.mapRequestToDto(postRequest));
    }

    @GetMapping(path = "posts")
    public List<PostResponse> getPosts() {
        return postService.getAllPosts();
    }
}
