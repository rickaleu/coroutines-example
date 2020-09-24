package br.com.ricardo.coroutinesmovies.main.repository

import br.com.ricardo.coroutinesmovies.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepositoryImpl : MainRepository {

    override fun getMovies(callback: (movies: List<Movie>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Movie(1, "Titulo 1"),
                    Movie(2, "Titulo 2")
                )
            )
        }).start()
    }

    override suspend fun getMoviesCoroutine(): List<Movie> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(Movie(1, "Titulo 1"),
                Movie(2, "Titulo 2"))
        }
    }


}