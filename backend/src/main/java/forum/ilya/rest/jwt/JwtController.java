package forum.ilya.rest.jwt;

import forum.ilya.core.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt")
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    @PostMapping("login")
    public String create(@RequestBody LoginRequest loginRequest) {
        return jwtService.create(loginRequest.login(), loginRequest.password());
    }
}
