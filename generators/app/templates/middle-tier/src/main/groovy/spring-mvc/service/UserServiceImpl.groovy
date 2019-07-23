package <%= packageName %>.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.UserRepository

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository

    Optional<User> user(String username) {
        return userRepository.readUser(username)
    }

    List<User> users() {
        return userRepository.readUsers()
    }

}
