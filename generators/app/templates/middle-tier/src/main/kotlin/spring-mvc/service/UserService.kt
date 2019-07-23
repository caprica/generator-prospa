package <%= packageName %>.service

import <%= packageName %>.domain.User

/**
 * Business service dealing with Users.
 */
interface UserService {

    fun users(): Collection<User>

    fun user(username: String): User?

}
