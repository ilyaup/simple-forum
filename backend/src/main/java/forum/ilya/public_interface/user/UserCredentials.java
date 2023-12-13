package forum.ilya.public_interface.user;

import lombok.Builder;

@Builder
public record UserCredentials(
        String login,
        String password,
        String email
) {
}
