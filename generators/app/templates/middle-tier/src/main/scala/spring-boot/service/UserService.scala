package <%= packageName %>.service

import <%= packageName %>.domain.User

/**
  * Business service dealing with Users.
  */
trait UserService {

    def users: List[User]

    def user(username: String): Option[User]

}
