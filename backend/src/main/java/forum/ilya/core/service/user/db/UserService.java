package forum.ilya.core.service.user.db;

import forum.ilya.public_interface.user.UserCredentials;
import forum.ilya.rest.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public long saveUser(UserCredentials userCredentials) {
        return userRepository.save(mapCredentialsToDao(userCredentials)).getId();
    }

    private UserAccount mapCredentialsToDao(UserCredentials userCredentials) {
        return UserAccount.builder()
                .login(userCredentials.login())
                .password(userCredentials.password())
                .email(userCredentials.email())
                .build();
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapDaoToResponse)
                .collect(Collectors.toList());
    }

    private UserResponse mapDaoToResponse(UserAccount userAccount) {
        return UserResponse.builder()
                .login(userAccount.getLogin())
                .id(userAccount.getId())
                .email(userAccount.getEmail())
                .rating(userAccount.getRating())
                .build();
    }

    public long getUserIdByLoginAndPassword(String login, String password) {
        return userRepository.getUserAccountByLoginAndPassword(login, password).orElseThrow().getId();
    }

    public UserResponse getUserById(long userId) {
        return mapDaoToResponse(userRepository.getUserAccountById(userId).orElseThrow());
    }
}
