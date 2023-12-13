package forum.ilya.rest.post;

import lombok.Builder;

@Builder
public record PostResponse (
        long postId,
        long userId,
        String content,
        long likes
) {
}
