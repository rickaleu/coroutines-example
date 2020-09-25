package br.com.ricardo.coroutinesmovies.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.ricardo.coroutinesmovies.R
import br.com.ricardo.coroutinesmovies.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel{
        parametersOf(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this,
//            MainViewModelFactory(MainRepositoryImpl())).get(MainViewModel::class.java)

        viewModel.movieMutableLiveData.observe(viewLifecycleOwner, Observer { movies ->
            text_movie_title.text = movies.map {
                "${it.id} - ${it.title}"
            }.toString()
        })
    }

    override fun onResume() {
        super.onResume()

//        viewModel.getMovies()
        viewModel.getMoviesCoroutine()
    }
}