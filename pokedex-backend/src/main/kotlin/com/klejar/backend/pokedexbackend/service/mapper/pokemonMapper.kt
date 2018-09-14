package com.klejar.backend.pokedexbackend.service.mapper

import com.klejar.backend.pokedexbackend.entity.Pokemon
import com.klejar.backend.pokedexbackend.service.DTO.PokemonDto

public class PokemonMapper  {
    companion object {
         fun toDto(pokemon: Pokemon) = PokemonDto(pokemon.id, pokemon.abilities, pokemon.weight, pokemon.weakness, pokemon.number, pokemon.height, pokemon.collectibles_slug, pokemon.featured, pokemon.slug,pokemon.name,pokemon.ThumbnailAltText,pokemon.ThumbnailImage,pokemon.type)

         fun fromDto(pokemonDto: PokemonDto) = Pokemon(pokemonDto.id, pokemonDto.abilities, pokemonDto.weight, pokemonDto.weakness, pokemonDto.number, pokemonDto.height, pokemonDto.collectibles_slug, pokemonDto.featured, pokemonDto.slug,pokemonDto.name,pokemonDto.thumbnailAltText,pokemonDto.thumbnailImage, pokemonDto.type)
    }
}