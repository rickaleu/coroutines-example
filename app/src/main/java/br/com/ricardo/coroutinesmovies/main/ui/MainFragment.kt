package br.com.ricardo.coroutinesmovies.main.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.ricardo.coroutinesmovies.main.viewmodel.MainViewModel
import br.com.ricardo.coroutinesmovies.R
import br.com.ricardo.coroutinesmovies.main.repository.MainRepository
import br.com.ricardo.coroutinesmovies.main.repository.MainRepositoryImpl
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory(MainRepositoryImpl()))
            .get(MainViewModel::class.java)

        viewModel.movieMutableLiveData.observe(viewLifecycleOwner, Observer { movies ->
            text_movie_title.text = movies[0].title
        })
    }

    override fun onResume() {
        super.onResume()
//        viewModel.getMovies()
        viewModel.getMoviesCoroutine()
    }
}