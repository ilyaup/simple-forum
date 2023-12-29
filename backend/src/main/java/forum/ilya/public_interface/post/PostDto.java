package forum.ilya.public_interface.post;

import lombok.Builder;

@Builder
public record PostDto(
        long userId,
        String title,
        String content
) {
}
