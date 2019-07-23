package <%= packageName %>.repository

import <%= packageName %>.domain.User

/**
 * Repository dealing with Users.
 */
trait UserRepository {

    abstract List<User> readUsers()

    abstract Optional<User> readUser(String username)

}
