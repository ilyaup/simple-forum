package forum.ilya.rest.post;

import forum.ilya.public_interface.post.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostDto mapRequestToDto(PostRequest postRequest) {
        return PostDto.builder()
                .userId(postRequest.userId())
                .title(postRequest.title())
                .content(postRequest.content())
                .build();
    }

}
