package <%= packageName %>.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Immutable domain object to represent a User.
 */
class User @JsonCreator
constructor(
    @param:JsonProperty("username") @field:JsonProperty("username") private val username: String,
    @param:JsonProperty("name") @field:JsonProperty("name") private val name: String) {

    fun username(): String {
        return username
    }

    fun name(): String {
        return name
    }

}
