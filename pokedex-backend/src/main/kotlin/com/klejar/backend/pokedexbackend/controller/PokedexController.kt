package com.klejar.backend.pokedexbackend.controller

import com.klejar.backend.pokedexbackend.entity.Pokemon
import com.klejar.backend.pokedexbackend.service.DTO.PokemonDto
import com.klejar.backend.pokedexbackend.service.PokedexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PokedexController {

    @Autowired
    private lateinit var pokedexService: PokedexService

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/")

    fun rootPage(): ArrayList<PokemonDto> {
        return pokedexService.findAll()
    }
}