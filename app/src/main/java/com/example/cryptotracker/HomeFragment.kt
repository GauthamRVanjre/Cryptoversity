package com.example.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptotracker.adapter.CoinAdapter
import com.example.cryptotracker.databinding.FragmentHomeBinding
import com.example.cryptotracker.viewModel.CoinViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel : CoinViewModel by viewModels()
    lateinit var coinAdapter: CoinAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        val navBar : BottomNavigationView? = activity?.findViewById(R.id.bottomNavigationView)
        navBar?.visibility = View.VISIBLE

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getCoins()
        viewModel.coinsList.observe(viewLifecycleOwner,{
            coinList ->
                coinAdapter = CoinAdapter(requireContext(),coinList)
                binding.recyclerView.adapter = coinAdapter
                binding.progressBar.isVisible = false
        })
        return binding.root
    }

}