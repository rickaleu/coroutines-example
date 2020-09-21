package br.com.ricardo.coroutinesmovies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ricardo.coroutinesmovies.main.repository.MainRepository
import br.com.ricardo.coroutinesmovies.main.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}