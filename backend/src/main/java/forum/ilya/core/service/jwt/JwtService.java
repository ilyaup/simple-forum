package forum.ilya.core.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import forum.ilya.core.service.user.db.UserService;
import forum.ilya.rest.user.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    private static final String SECRET = "38c86b553adefeb3e579e39789e38664aef9176e";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    private static final JWTVerifier verifier = JWT.require(algorithm).build();

    private final UserService userService;

    public String create(String login, String password) {
        long userId = userService.getUserIdByLoginAndPassword(login, password);
        return JWT.create()
                .withClaim("userId", userId)
                .sign(algorithm);
    }

    public UserResponse find(String jwt) {
        try {
            DecodedJWT decodedJwt = verifier.verify(jwt);
            UserResponse userResponse = userService.getUserById(decodedJwt.getClaim("userId").asLong());
            log.info(userResponse.toString());
            return userResponse;
        } catch (JWTVerificationException exception) {
            return null;
        }
    }
}
