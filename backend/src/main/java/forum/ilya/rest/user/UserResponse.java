package forum.ilya.rest.user;

import lombok.Builder;
import lombok.ToString;

@Builder
public record UserResponse(
        long id,
        String login,
        String email,
        long rating
) {
}
