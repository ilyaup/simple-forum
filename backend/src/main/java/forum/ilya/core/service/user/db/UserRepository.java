package forum.ilya.core.service.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> getUserAccountById(long userId);
}
