package <%= packageName %>.domain

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

/**
  * Immutable domain object to represent a User.
  */
case class User @JsonCreator() (
    @JsonProperty("username") username: String,
    @JsonProperty("name") name: String
)
