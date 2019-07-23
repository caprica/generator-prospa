package <%= packageName %>.service;

import java.util.List;
import java.util.Optional;

import <%= packageName %>.domain.User;

/**
 * Business service dealing with Users.
 */
public interface UserService {

    List<User> users();

    Optional<User> user(String username);

}
