package forum.ilya.rest.user;

import forum.ilya.public_interface.user.UserCredentials;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMapper {

    public UserCredentials mapRequestToCredentials(RegisterRequest registerRequest) {
        return UserCredentials.builder()
                .login(registerRequest.login())
                .password(registerRequest.password())
                .email(registerRequest.email())
                .build();
    }
}
