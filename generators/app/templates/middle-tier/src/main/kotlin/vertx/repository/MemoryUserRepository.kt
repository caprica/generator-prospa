package <%= packageName %>.repository

import <%= packageName %>.domain.User

class MemoryUserRepository : UserRepository {

    override fun readUsers(): Collection<User> {
        return users.values
    }

    override fun readUser(username: String): User? {
        return users[username]
    }

    companion object {

        private val users = mapOf(
            "boss"     to User("boss"    , "Sword Saint Isshin"   ),
            "emma"     to User("emma"    , "The Gentle Blade"     ),
            "emo"      to User("emo"     , "Genichiro"            ),
            "dad"      to User("dad"     , "Great Shinobi Owl"    ),
            "bananas"  to User("bananas" , "Guardian Ape"         ),
            "granny"   to User("granny"  , "Lady Butterfly"       ),
            "horseguy" to User("horseguy", "Gyoubu Masataka Oniwa"),
            "scorchio" to User("scorchio", "Demon of Hatred"      )
        )

    }

}
