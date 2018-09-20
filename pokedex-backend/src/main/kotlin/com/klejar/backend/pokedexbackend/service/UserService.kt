package com.klejar.backend.pokedexbackend.service

import com.klejar.backend.pokedexbackend.entity.UserEntity
import com.klejar.backend.pokedexbackend.repository.UserRepository
import com.klejar.backend.pokedexbackend.service.DTO.UserDto

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder
    fun save(userDto: UserDto):UserEntity{

        val user = UserDto.fromDto(userDto)

        user.password = passwordEncoder.encode(user.password)

        return userRepository.save(user)
    }

    fun findByUsername(username: String): UserEntity {
        return userRepository.findByUsername(username)

    }
}