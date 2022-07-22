package com.example.cryptotracker.repository

import com.example.cryptotracker.database.CoinDao
import com.example.cryptotracker.database.CoinDatabase
import com.example.cryptotracker.network.Coins


class CoinRepository(private val coinDao: CoinDao) {

//    fun getFavCoins() = db.getCoinDAO().getfavCoins()
//
//    fun addCoin(coins: Coins) = db.getCoinDAO().addCoin(coins)
//
//    fun deleteCoin(coins: Coins) = db.getCoinDAO().deleteCoin(coins)

    fun getFavCoins() = coinDao.getfavCoins()

    fun addCoin(coins: Coins) = coinDao.addCoin(coins)

    fun deleteCoin(coins: Coins) = coinDao.deleteCoin(coins)

}