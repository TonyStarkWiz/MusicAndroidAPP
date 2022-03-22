package com.android.starwarscatapp.views

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.starwarscatapp.R
import com.android.starwarscatapp.StarWarsApp
import com.android.starwarscatapp.adapter.CharactersAdapter
import com.android.starwarscatapp.databinding.FragmentPeopleBinding
import com.android.starwarscatapp.model.Result
import com.android.starwarscatapp.model.TrackMusic
import com.android.starwarscatapp.presenters.PeopleViewContract
import com.android.starwarscatapp.presenters.StarWarsPeoplePresenterImpl
import javax.inject.Inject

class PeopleFragment : BaseFragment(), PeopleViewContract {

//    private var _binding : FragmentPeopleBinding? = null
    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    @Inject lateinit var presenter: StarWarsPeoplePresenterImpl

    private val player by lazy {
        MediaPlayer()
    }

    private val songAdapter by lazy {
        CharactersAdapter(onSongClicked = {
            player.stop()
            player.reset()
            player.setDataSource(it.previewUrl)
            player.prepare()
            player.start()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StarWarsApp.starWarsComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.myCharactersRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = songAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initializePresenter(this)
        presenter.getStarWarsCharacters()
    }

    companion object {
        fun newInstance() = PeopleFragment()
    }

    override fun loadingCharacters(isLoading: Boolean) {
        binding.loadingBar.visibility = View.VISIBLE
        binding.myCharactersRecycler.visibility = View.GONE
    }

    override fun charactersSuccess(characters: List<Result>) {
        binding.loadingBar.visibility = View.GONE
        binding.myCharactersRecycler.visibility = View.VISIBLE
        songAdapter.updateSongs(characters)

    }

    override fun onError(error: Throwable) {
        binding.loadingBar.visibility = View.GONE
        binding.myCharactersRecycler.visibility = View.GONE
        Toast.makeText(requireContext(), "onError", Toast.LENGTH_LONG).show()
//        error.printStackTrace()
    }
}