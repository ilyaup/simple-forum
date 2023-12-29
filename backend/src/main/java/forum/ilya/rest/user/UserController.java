package forum.ilya.rest.user;

import forum.ilya.core.service.jwt.JwtService;
import forum.ilya.core.service.user.RegisterService;
import forum.ilya.core.service.user.db.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final CredentialsMapper credentialsMapper;
    private final RegisterService registerService;
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping(path = "register")
    public long register(@RequestBody RegisterRequest registerRequest) {
        log.info("Someone is registered: " + registerRequest.login() + " " + registerRequest);
        return registerService.registerUser(credentialsMapper.mapRequestToCredentials(registerRequest));
    }

    @GetMapping(path = "users")
    public List<UserResponse> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "auth")
    public UserResponse findUserByJwt(@RequestParam String jwt) {
        return jwtService.find(jwt);
    }
}
