package forum.ilya.rest.user;

import lombok.Builder;

@Builder
public record UserResponse(
        String login,
        String email,
        long rating
) {
}
