package com.songbook.cognizantcodingchallenge.ui.listFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.songbook.cognizantcodingchallenge.databinding.FragmentListBinding
import com.songbook.cognizantcodingchallenge.model.SuperHero
import com.songbook.cognizantcodingchallenge.repository.Repository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {

    @Inject
    lateinit var repository: Repository
    private lateinit var viewModel: ListViewModel

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupList(items: List<SuperHeroesRvItem>) {
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(items)
        }

        binding.superHeroList.adapter = groupAdapter

    }

    private fun setupViewModel() {

        viewModel = ViewModelProvider(
            this, ListViewModelFactory(repository)
        ).get(ListViewModel::class.java)

        viewModel.fetchSuperHeroesList()

        viewModel.superHero.observe(viewLifecycleOwner) {
            setupList(it.toRecyclerviewListItem())
        }

    }

    private fun List<SuperHero>.toRecyclerviewListItem(): List<SuperHeroesRvItem> {
        return this.map {
            SuperHeroesRvItem(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}