package com.android.starwarscatapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.starwarscatapp.R
import com.android.starwarscatapp.databinding.FragmentPeopleBinding

class PeopleFragment : BaseFragment() {

    private var _binding : FragmentPeopleBinding? = null
    private val binding : FragmentPeopleBinding? get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)

        binding?.myCharactersRecycler?.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        return binding?.root
    }


    companion object {
        fun newInstance() = PeopleFragment()
    }
}