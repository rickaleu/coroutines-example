package br.com.ricardo.coroutinesmovies.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ricardo.coroutinesmovies.data.model.Movie
import br.com.ricardo.coroutinesmovies.main.repository.MainRepository
import br.com.ricardo.coroutinesmovies.main.repository.MainRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val movieMutableLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMovies { movies ->
            movieMutableLiveData.postValue(movies)
        }
    }

    fun getMoviesCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutine()
            }

            movieMutableLiveData.value = movies
        }
    }
}