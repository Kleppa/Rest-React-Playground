package com.klejar.backend.pokedexbackend.repository

import com.klejar.backend.pokedexbackend.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<UserEntity,Long>{
    fun findByUsername(username:String):UserEntity
}