package <%= packageName %>.repository

import <%= packageName %>.domain.User

class MemoryUserRepository implements UserRepository {

    private static final Map<String, User> users = new HashMap<>()

    static {
        users.put("boss", new User("boss", "Sword Saint Isshin"))
        users.put("emma", new User("emma", "The Gentle Blade"))
        users.put("emo", new User("emo", "Genichiro"))
        users.put("dad", new User("dad", "Great Shinobi Owl"))
        users.put("bananas", new User("bananas", "Guardian Ape"))
        users.put("granny", new User("granny", "Lady Butterfly"))
        users.put("horseguy", new User("horseguy", "Gyoubu Masataka Oniwa"))
        users.put("scorchio", new User("scorchio", "Demon of Hatred"))
    }

    List<User> readUsers() {
        return Collections.unmodifiableList(new ArrayList<>(users.values()))
    }

    Optional<User> readUser(String username) {
        User user = users.get(username)
        return Optional.ofNullable(user)
    }

}
