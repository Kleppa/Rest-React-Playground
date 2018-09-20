package com.klejar.backend.pokedexbackend.controller

import com.google.gson.Gson
import com.klejar.backend.pokedexbackend.service.CustomUserDetailsService
import com.klejar.backend.pokedexbackend.service.DTO.UserDto
import com.klejar.backend.pokedexbackend.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList

@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder
    // @Autowired
    // private lateinit var userDetailsService: UserDetailsService
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var customUserDetailsService: CustomUserDetailsService


    @PostMapping(value = ["/create/user"], consumes = ["Application/json"])
    fun createUser(@RequestBody user: String): ResponseEntity<Void> {
        println("This is the user $user");

        val userDto = Gson().fromJson(user, UserDto::class.java)
        userService.save(userDto)
        return ResponseEntity.status(200).build()
    }

    @PostMapping(value = ["/login"], consumes = ["Application/json","application/x-www-form-urlencoded"])
    fun login(@RequestBody user: String): ResponseEntity<Void> {
        println("USER $user")

        val userDto = Gson().fromJson(user, UserDto::class.java)
        try {

            val user = userService.findByUsername(userDto.username)

            println("user roles ${user.roles}")

            println("this is useruser.roles size ${user.roles?.size}")

            val userDetails =  customUserDetailsService.loadUserByUsername(user.username)


            val token = UsernamePasswordAuthenticationToken(userDetails, userDto.password,userDetails.authorities)
            println(token)
            authenticationManager.authenticate(token)

            if (token.isAuthenticated) {
                println("Token is authenticated")
                SecurityContextHolder.getContext().authentication = token
            } else {
                println("Token is not authenticated")
            }
        } catch (err: Exception) {
            println("Error occured $err")
        }
        return ResponseEntity.status(204).build()

    }
}

