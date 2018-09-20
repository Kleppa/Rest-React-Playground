package com.klejar.backend.pokedexbackend.entity


import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class UserEntity (
        @get:Id
        @get:GeneratedValue
        var id: Long? = 0,

        @get:NotNull
        var username: String,
        @get:NotNull
        var password: String,

        @get:ElementCollection
        @get:NotNull
        var roles: Set<String>? = setOf()
) {


}