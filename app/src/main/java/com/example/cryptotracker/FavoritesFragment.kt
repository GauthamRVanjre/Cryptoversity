package com.example.cryptotracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.adapter.CoinAdapter
import com.example.cryptotracker.databinding.FragmentFavoritesBinding
import com.example.cryptotracker.viewModel.CoinViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


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

        val navBar : BottomNavigationView? = activity?.findViewById(R.id.bottomNavigationView)
        navBar?.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getFavCoins().observe(viewLifecycleOwner,{
            favCoinsList ->
                coinAdapter = CoinAdapter(requireContext(),favCoinsList)
                binding.recyclerView.adapter = coinAdapter
                binding.progressBar.visibility = View.GONE
        })

        //deltion of coins using swiping options
        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition
                val coin = coinAdapter.coinList[position]
                viewModel.deleteCoin(coin)
                Toast.makeText(requireContext(),"${coin.name} successfully removed from favorites",
                Toast.LENGTH_SHORT).show()
            }
        }

        ItemTouchHelper(itemTouchHelperCallBack).apply {
            attachToRecyclerView(binding.recyclerView)
        }

        return binding.root
    }


}