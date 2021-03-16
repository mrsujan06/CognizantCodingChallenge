package com.songbook.cognizantcodingchallenge.data

import com.songbook.cognizantcodingchallenge.model.SuperHero

class DataSource {

    private val superHeroList = listOf(
        SuperHero("Captain America"),
        SuperHero("Iron Man"),
        SuperHero("Hulk"),
        SuperHero("Black Widow"),
        SuperHero("Thor"),
        SuperHero("Spider Man"),
        SuperHero("Batman"),
        SuperHero("Superman"),
        SuperHero("Flash"),
        SuperHero("Wonder women"),
        SuperHero("Ant man"),
        SuperHero("Hawk eye"),
        SuperHero("Sujan Thapa"),
    )

    fun getSuperHeroList() = superHeroList
}