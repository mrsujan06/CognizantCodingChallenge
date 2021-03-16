package com.songbook.cognizantcodingchallenge.repository

import com.songbook.cognizantcodingchallenge.data.DataSource

class Repository(private val data: DataSource) {

    fun getSuperHeroes() = data.getSuperHeroList()

}