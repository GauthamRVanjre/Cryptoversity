package com.example.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cryptotracker.databinding.FragmentDetailBinding
import com.example.cryptotracker.databinding.FragmentHomeBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    val args : DetailFragmentArgs by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        binding.coinName.text = args.coinData.name
        binding.coinRank.text = args.coinData.rank
        binding.coinSymbol.text = args.coinData.symbol
        return binding.root
    }

}