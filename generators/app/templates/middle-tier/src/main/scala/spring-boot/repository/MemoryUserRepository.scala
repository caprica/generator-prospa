package <%= packageName %>.repository

import org.springframework.stereotype.Repository

import <%= packageName %>.domain.User

object MemoryUserRepository {

    private val users = Map(
        "boss"     -> User("boss"    , "Sword Saint Isshin"   ),
        "emma"     -> User("emma"    , "The Gentle Blade"     ),
        "emo"      -> User("emo"     , "Genichiro"            ),
        "dad"      -> User("dad"     , "Great Shinobi Owl"    ),
        "bananas"  -> User("bananas" , "Guardian Ape"         ),
        "granny"   -> User("granny"  , "Lady Butterfly"       ),
        "horseguy" -> User("horseguy", "Gyoubu Masataka Oniwa"),
        "scorchio" -> User("scorchio", "Demon of Hatred"      )
    )

}

@Repository
class MemoryUserRepository extends UserRepository {

    @Override def readUsers: List[User] = MemoryUserRepository.users.values.toList

    @Override def readUser(username: String): Option[User] = MemoryUserRepository.users.get(username)

}
