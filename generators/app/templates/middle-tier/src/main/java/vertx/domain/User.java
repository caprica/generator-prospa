package <%= packageName %>.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Immutable domain object to represent a User.
 */
public final class User {

    @JsonProperty("username")
    private final String username;

    @JsonProperty("name")
    private final String name;

    @JsonCreator
    public User(@JsonProperty("username") String username, @JsonProperty("name") String name) {
        this.username = username;
        this.name = name;
    }

    public String username() {
        return username;
    }

    public String name() {
        return name;
    }

}
