package com.klejar.backend.pokedexbackend.entity


import javax.persistence.*


@Entity
@Table(name = "pokemon")
class Pokemon(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val abilities: Array<String>,
        val weight: Number,
        val weakness: Array<String>,
        val number: Number,
        val height: Number,
        val collectibles_slug:String,
        val featured: String,
        val slug: String,
        val name: String,
        val ThumbnailAltText: String,
        val ThumbnailImage: String,
        val type: Array<String>

        ) {


}
