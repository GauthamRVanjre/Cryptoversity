package com.example.cryptotracker.network

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "coinEntity")
data class Coins(

    @PrimaryKey
    var id: String,
    var last_updated: String,
    var market_cap_usd: String,
    var max_supply: String,
    var name: String,
    var percent_change_1h: String,
    var percent_change_24h: String,
    var percent_change_7d: String,
    var price_btc: String,
    var price_usd: String,
    var rank: String,
    var symbol: String,
    var total_supply: String
) : Parcelable
{
    constructor() : this("","","","","","","",
        "","","","","","",
        )
}