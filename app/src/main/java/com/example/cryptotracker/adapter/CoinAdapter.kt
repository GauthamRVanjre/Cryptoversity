package com.example.cryptotracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.databinding.ListViewItemBinding
import com.example.cryptotracker.network.Coins

class CoinAdapter(val requireContext: Context, var coinList: List<Coins>) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(val binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            ListViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val currentCoin = coinList[position]
        holder.binding.coinRank.text = currentCoin.rank
        holder.binding.coinName.text = currentCoin.name
        holder.binding.coinSymbol.text = currentCoin.symbol
        val price = currentCoin.price_usd.toDouble()
        val stringPrice = String.format("%.3f",price)
        holder.binding.coinPrice.text = stringPrice
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}