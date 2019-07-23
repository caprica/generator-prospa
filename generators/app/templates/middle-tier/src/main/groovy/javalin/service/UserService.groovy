package <%= packageName %>.service

import <%= packageName %>.domain.User

/**
 * Business service dealing with Users.
 */
trait UserService {

    abstract List<User> users()

    abstract Optional<User> user(String username)

}
