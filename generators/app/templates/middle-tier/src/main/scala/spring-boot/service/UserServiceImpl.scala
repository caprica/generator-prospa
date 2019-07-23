package <%= packageName %>.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import <%= packageName %>.domain.User
import <%= packageName %>.repository.UserRepository

@Service
class UserServiceImpl extends UserService {

    @Autowired
    private val userRepository: UserRepository = null

    override def users: List[User] = userRepository.readUsers

    override def user(username: String): Option[User] = userRepository.readUser(username)

}
