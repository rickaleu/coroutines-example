package br.com.ricardo.coroutinesmovies.main.repository

import br.com.ricardo.coroutinesmovies.data.model.Movie

interface MainRepository {

    fun getMovies(callback: (movies: List<Movie>) -> Unit)
    suspend fun getMoviesCoroutine() : List<Movie>

}