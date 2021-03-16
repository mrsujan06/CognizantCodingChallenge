package com.songbook.cognizantcodingchallenge.ui.listFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.songbook.cognizantcodingchallenge.repository.Repository
import javax.inject.Inject

class ListViewModelFactory @Inject constructor(
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}