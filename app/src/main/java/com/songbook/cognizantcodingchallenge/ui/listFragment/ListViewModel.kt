package com.songbook.cognizantcodingchallenge.ui.listFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.songbook.cognizantcodingchallenge.model.SuperHero
import com.songbook.cognizantcodingchallenge.repository.Repository
import javax.inject.Inject

class ListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _superHeroes = MutableLiveData<List<SuperHero>>()
    val superHero: LiveData<List<SuperHero>> = _superHeroes

    fun fetchSuperHeroesList() {
        _superHeroes.value = repository.getSuperHeroes()
    }

}