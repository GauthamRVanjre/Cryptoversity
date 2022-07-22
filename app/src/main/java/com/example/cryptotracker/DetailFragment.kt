package com.example.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.cryptotracker.databinding.FragmentDetailBinding
import com.example.cryptotracker.databinding.FragmentHomeBinding
import com.example.cryptotracker.network.Coins
import com.example.cryptotracker.viewModel.CoinViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    val viewModel: CoinViewModel by viewModels()
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

        val navBar : BottomNavigationView? = activity?.findViewById(R.id.bottomNavigationView)
        navBar?.visibility = View.GONE


        binding.favCoinBtn.setOnClickListener {
            val favCoinData = Coins(
                id = args.coinData.id,
                last_updated = args.coinData.last_updated,
                market_cap_usd = args.coinData.market_cap_usd,
                max_supply = args.coinData.max_supply,
                name = args.coinData.name,
                percent_change_1h = args.coinData.percent_change_1h,
                percent_change_24h = args.coinData.percent_change_24h,
                percent_change_7d = args.coinData.percent_change_7d,
                price_btc = args.coinData.price_btc,
                price_usd = args.coinData.price_usd,
                rank = args.coinData.rank,
                symbol = args.coinData.symbol,
                total_supply = args.coinData.total_supply
            )
            viewModel.addCoin(favCoinData)
            Toast.makeText(requireContext(),"${args.coinData.name} is added to favorites",Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it!!).navigate(R.id.action_detailFragment_to_homeFragment)
        }
        return binding.root
    }

}