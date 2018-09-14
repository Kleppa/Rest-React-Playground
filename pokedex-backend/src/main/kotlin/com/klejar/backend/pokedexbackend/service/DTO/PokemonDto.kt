package com.klejar.backend.pokedexbackend.service.DTO

import java.util.*

data class PokemonDto(
        val id: Long? = null,
        val abilities: Array<String>,
        val weight: Number,
        val weakness:Array<String>,
        val number: Number,
        val height: Number,
        val collectibles_slug:String,
        val featured: String,
        val slug: String,
        val name: String,
        val thumbnailAltText: String,
        val thumbnailImage: String,
        val type: Array<String>
        // val forms:Any
){


}
//        ) {
//
//    val types: ArrayList<String> = ArrayList()
//
//    val locs: HashMap<String,String> = HashMap()
//
//}