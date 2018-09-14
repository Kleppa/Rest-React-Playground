package com.klejar.backend.pokedexbackend.service

import com.klejar.backend.pokedexbackend.entity.Pokemon
import com.klejar.backend.pokedexbackend.repository.PokedexRepository
import com.klejar.backend.pokedexbackend.service.DTO.PokemonDto
import com.klejar.backend.pokedexbackend.service.mapper.PokemonMapper


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PokedexService {

    @Autowired
    private lateinit var pokedexRepository: PokedexRepository

    fun findAll(): ArrayList<PokemonDto> {

        val pokemonDtos = ArrayList<PokemonDto>()
        val findAll = pokedexRepository.findAll()
        findAll.forEach { pokemonDtos.add(PokemonMapper.toDto(it)) }

        return pokemonDtos
    }
}