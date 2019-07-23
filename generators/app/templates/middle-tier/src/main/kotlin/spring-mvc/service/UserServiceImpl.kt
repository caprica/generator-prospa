package <%= packageName %>.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.UserRepository

@Service
class UserServiceImpl : UserService {

    @Autowired
    private val userRepository: UserRepository? = null

    override fun users(): Collection<User> {
        return userRepository!!.readUsers()
    }

    override fun user(username: String): User? {
        return userRepository!!.readUser(username)
    }

}
