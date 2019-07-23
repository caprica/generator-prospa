package <%= packageName %>.repository;

import java.util.List;
import java.util.Optional;

import <%= packageName %>.domain.User;

/**
 * Repository dealing with Users.
 */
public interface UserRepository {

    List<User> readUsers();

    Optional<User> readUser(String username);

}
