package forum.ilya.rest.post;

import lombok.Builder;

@Builder
public record PostRequest(
        long userId,
        String content
) {
}
