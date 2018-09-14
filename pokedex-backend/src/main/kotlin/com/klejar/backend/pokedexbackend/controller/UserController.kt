package com.klejar.backend.pokedexbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @PostMapping("/create/user")
    fun createUser():ResponseEntity<Void>{
        return ResponseEntity.status(200).build()
    }
}