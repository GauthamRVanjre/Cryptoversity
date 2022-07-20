package com.example.cryptotracker.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cryptotracker.network.Coins

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoin(coins: Coins)

    @Delete
    fun deleteCoin(coins: Coins)

    @Query("select * from COINENTITY ")
    fun getfavCoins() : LiveData<List<Coins>>

}