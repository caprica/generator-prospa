package <%= packageName %>.repository

import <%= packageName %>.domain.User

/**
 * Repository dealing with Users.
 */
interface UserRepository {

    fun readUsers(): Collection<User>

    fun readUser(username: String): User?

}
