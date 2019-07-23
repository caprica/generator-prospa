package <%= packageName %>.service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.MemoryUserRepository
import <%= packageName %>.repository.UserRepository

class UserServiceImpl implements UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private UserRepository userRepository = new MemoryUserRepository()

    Optional<User> user(String username) {
        return userRepository.readUser(username)
    }

    List<User> users() {
        return userRepository.readUsers()
    }

}
