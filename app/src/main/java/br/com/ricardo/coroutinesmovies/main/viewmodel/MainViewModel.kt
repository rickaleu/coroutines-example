package br.com.ricardo.coroutinesmovies.main.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ricardo.coroutinesmovies.data.model.Movie
import br.com.ricardo.coroutinesmovies.main.repository.MainRepository
import br.com.ricardo.coroutinesmovies.main.repository.MainRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository,
                    private val context: Context
) : ViewModel() {

    val movieMutableLiveData = MutableLiveData<List<Movie>>()

//    fun getMovies() {
//        repository.getMovies { movies ->
//            movieMutableLiveData.postValue(movies)
//        }
//    }

    fun getMoviesCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutine()
            }

            movieMutableLiveData.value = movies
        }


    }
}