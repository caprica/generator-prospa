package <%= packageName %>.service;

import java.util.List;
import java.util.Optional;

import <%= packageName %>.domain.User;
import <%= packageName %>.repository.MemoryUserRepository;
import <%= packageName %>.repository.UserRepository;

public class UserServiceImpl implements UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private UserRepository userRepository = new MemoryUserRepository();

    @Override
    public Optional<User> user(String username) {
        return userRepository.readUser(username);
    }

    @Override
    public List<User> users() {
        return userRepository.readUsers();
    }

}
