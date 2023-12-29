package forum.ilya.core.service.post.db;

import forum.ilya.core.service.user.db.UserRepository;
import forum.ilya.public_interface.post.PostDto;
import forum.ilya.rest.post.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public long createPost(PostDto postDto) {
        log.info(postDto.toString());
        return postRepository.save(mapDtoToDao(postDto)).getId();
    }

    private Post mapDtoToDao(PostDto postDto) {
        return Post.builder()
                .content(postDto.content())
                .title(postDto.title())
                .userAccount(userRepository.getUserAccountById(postDto.userId()).orElseThrow())
                .build();
    }

    private PostResponse mapDaoToResponse(Post post) {
        return PostResponse.builder()
                .authorLogin(post.getUserAccount().getLogin())
                .title(post.getTitle())
                .content(post.getContent())
                .likes(post.getLikes())
                .build();
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(this::mapDaoToResponse)
                .collect(Collectors.toList());
    }
}
