package forum.ilya.rest.post;

import lombok.Builder;

@Builder
public record PostResponse (
        String authorLogin,
        String title,
        String content,
        long likes
) {
}
