package <%= packageName %>.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Immutable domain object to represent a User.
 */
final class User {

    @JsonProperty("username")
    private final String username

    @JsonProperty("name")
    private final String name

    @JsonCreator
    User(@JsonProperty("username") String username, @JsonProperty("name") String name) {
        this.username = username
        this.name = name
    }

    String username() {
        return username
    }

    String name() {
        return name
    }

}
