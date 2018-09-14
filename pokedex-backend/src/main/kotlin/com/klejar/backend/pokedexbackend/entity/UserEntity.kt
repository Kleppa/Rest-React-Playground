package com.klejar.backend.pokedexbackend.entity


import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="USERS")
class UserEntity(
        @Id
        @GeneratedValue
        var id: Long? = 0,

        var username: String,

        var password: String,

        @get:ElementCollection
        @get:NotNull
        var roles: Set<String>? = setOf()


) {


}