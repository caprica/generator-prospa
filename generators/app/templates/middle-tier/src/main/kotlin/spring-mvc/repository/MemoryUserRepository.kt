package <%= packageName %>.repository

import org.springframework.stereotype.Repository

import <%= packageName %>.domain.User

@Repository
class MemoryUserRepository : UserRepository {

    override fun readUsers(): Collection<User> {
        return users.values
    }

    override fun readUser(username: String): User? {
        return users[username]
    }

    companion object {

        private val users = HashMap<String, User>()

        init {
            users["boss"] = User("boss", "Sword Saint Isshin")
            users["emma"] = User("emma", "The Gentle Blade")
            users["emo"] = User("emo", "Genichiro")
            users["dad"] = User("dad", "Great Shinobi Owl")
            users["bananas"] = User("bananas", "Guardian Ape")
            users["granny"] = User("granny", "Lady Butterfly")
            users["horseguy"] = User("horseguy", "Gyoubu Masataka Oniwa")
            users["scorchio"] = User("scorchio", "Demon of Hatred")
        }
    }

}
