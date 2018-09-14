package com.klejar.backend.pokedexbackend.repository

import com.klejar.backend.pokedexbackend.entity.Pokemon
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PokedexRepository :CrudRepository<Pokemon,Long>