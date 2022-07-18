package com.example.cryptotracker.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val BASE_URL="https://api.alternative.me/v1/"

//adding converter factory to the retrofit object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


//using retrofit object calling api interface to complete the api call
object RetrofitInstance {
    val api : CoinApi by lazy {
        retrofit.create(CoinApi::class.java)
    }
}