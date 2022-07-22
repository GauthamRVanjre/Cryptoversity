package com.example.cryptotracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.database.CoinDao
import com.example.cryptotracker.database.CoinDatabase
import com.example.cryptotracker.network.Coins
import com.example.cryptotracker.network.RetrofitInstance
import com.example.cryptotracker.repository.CoinRepository
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var coinRepository: CoinRepository

    init {
        val dao = CoinDatabase.invoke(application).getCoinDAO()
        coinRepository = CoinRepository(dao)
    }

    //deals with network call
    private val _coinsList = MutableLiveData<List<Coins>>()
    val coinsList : LiveData<List<Coins>> = _coinsList

    fun getCoins(){
        viewModelScope.launch {
            try{
                _coinsList.value = RetrofitInstance.api.getCoins()
            }
            catch (e:Exception){
                _coinsList.value = listOf()
            }
        }
    }

    //deals with database operations
    fun getFavCoins() : LiveData<List<Coins>> = coinRepository.getFavCoins()

    fun addCoin(coins: Coins) = coinRepository.addCoin(coins)

    fun  deleteCoin(coins: Coins) = coinRepository.deleteCoin(coins)

}