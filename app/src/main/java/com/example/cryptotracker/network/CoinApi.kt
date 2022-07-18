package com.example.cryptotracker.network

import retrofit2.http.GET

interface CoinApi {

    @GET(value = "ticker")
    suspend fun getCoins() : List<Coins>

}