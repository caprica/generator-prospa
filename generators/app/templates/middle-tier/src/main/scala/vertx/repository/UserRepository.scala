package <%= packageName %>.repository

import <%= packageName %>.domain.User

/**
  * Repository dealing with Users.
  */
trait UserRepository {

    def readUsers: List[User]

    def readUser(username: String): Option[User]

}
