package com.klejar.backend.pokedexbackend.service.DTO

import com.klejar.backend.pokedexbackend.entity.UserEntity

data class UserDto(val id:Long?,val username :String, val password:String,val roles:Set<String> =setOf()) {
    companion object {
        fun fromDto(userDto:UserDto):UserEntity = UserEntity(userDto.id,userDto.username,userDto.password,roles = setOf("USER"))
        fun toDto(user:UserEntity):UserDto = UserDto(user.id,user.username,user.password, user.roles!!)
    }
}