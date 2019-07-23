package <%= packageName %>.service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.MemoryUserRepository

class UserServiceImpl : UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userRepository = MemoryUserRepository()

    override fun users(): Collection<User> {
        return userRepository.readUsers()
    }

    override fun user(username: String): User? {
        return userRepository.readUser(username)
    }

}
