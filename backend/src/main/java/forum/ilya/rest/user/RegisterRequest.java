package forum.ilya.rest.user;

public record RegisterRequest(
        String login,
        String password,
        String email
) {
}
