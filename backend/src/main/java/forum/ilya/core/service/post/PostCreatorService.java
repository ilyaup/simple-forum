package forum.ilya.core.service.post;

import forum.ilya.core.service.post.db.PostService;
import forum.ilya.public_interface.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCreatorService {

    private final PostService postService;

    public long createPost(PostDto postDto) {
        return postService.createPost(postDto);
    }
}
