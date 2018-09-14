package com.klejar.backend.pokedexbackend.utils

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.klejar.backend.pokedexbackend.entity.Pokemon
import com.klejar.backend.pokedexbackend.repository.PokedexRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.File
import java.io.InputStream
import java.util.ArrayList



@Component
class PokedexFileUpdater {
    @Autowired
    private lateinit var pokedexRepository: PokedexRepository

    @Scheduled(fixedRate = 1 * 1000 * 60)
    fun databaseFiller(){
        val inputStream: InputStream = File("pokedex-backend/pokemon-with-links.json").inputStream()

        val json = inputStream.bufferedReader().use { it.readText() }

        val pokemonList = object : TypeToken<Collection<Pokemon>>() {
        }.getType()

        val pokedexJson = Gson().fromJson<ArrayList<Pokemon>>(json, pokemonList)
        pokedexRepository.saveAll(pokedexJson)


    }
}