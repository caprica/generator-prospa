package <%= packageName %>.service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.MemoryUserRepository

class UserServiceImpl extends UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userRepository = new MemoryUserRepository

    @Override def users: List[User] = userRepository.readUsers

    @Override def user(username: String): Option[User] = userRepository.readUser(username)

}
