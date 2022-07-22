package com.example.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptotracker.adapter.CoinAdapter
import com.example.cryptotracker.databinding.FragmentFavoritesBinding
import com.example.cryptotracker.viewModel.CoinViewModel


class FavoritesFragment : Fragment() {

    lateinit var binding: FragmentFavoritesBinding
    lateinit var coinAdapter: CoinAdapter
    val viewModel : CoinViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(layoutInflater,container,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getFavCoins().observe(viewLifecycleOwner,{
            favCoinsList ->
                coinAdapter = CoinAdapter(requireContext(),favCoinsList)
                binding.recyclerView.adapter = coinAdapter
                binding.progressBar.visibility = View.GONE
        })

        return binding.root
    }


}