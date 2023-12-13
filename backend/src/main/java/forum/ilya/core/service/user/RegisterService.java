package forum.ilya.core.service.user;

import forum.ilya.core.service.user.db.UserService;
import forum.ilya.public_interface.user.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserService userService;

    public long registerUser(UserCredentials userCredentials) {
        return userService.saveUser(userCredentials);
    }
}
