package br.com.ricardo.coroutinesmovies.di

import android.content.Context
import br.com.ricardo.coroutinesmovies.main.repository.MainRepository
import br.com.ricardo.coroutinesmovies.main.repository.MainRepositoryImpl
import br.com.ricardo.coroutinesmovies.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<MainRepository> {
        MainRepositoryImpl()
    }

    viewModel { (context: Context) ->
        MainViewModel(
            repository = get(),
            context = context
        )
    }
}