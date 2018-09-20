package com.klejar.backend.pokedexbackend.service

import com.klejar.backend.pokedexbackend.repository.UserRepository
import com.klejar.backend.pokedexbackend.utils.MyUserPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.apache.tomcat.jni.User.username
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User.UserBuilder
import org.springframework.stereotype.Service


@Service
class CustomUserDetailsService:UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository
    override fun loadUserByUsername(p0: String): UserDetails {
        val user = userRepository.findByUsername(p0)
        return MyUserPrincipal(user);


    }
}