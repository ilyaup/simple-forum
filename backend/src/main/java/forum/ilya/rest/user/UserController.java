package forum.ilya.rest.user;

import forum.ilya.core.service.user.RegisterService;
import forum.ilya.core.service.user.db.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final CredentialsMapper credentialsMapper;
    private final RegisterService registerService;
    private final UserService userService;

    @PostMapping(path = "/register")
    public long register(@RequestBody RegisterRequest registerRequest) {
        return registerService.registerUser(credentialsMapper.mapRequestToCredentials(registerRequest));
    }

    @GetMapping(path = "/users")
    public List<UserResponse> getUsers() {
        return userService.getAllUsers();
    }
}
