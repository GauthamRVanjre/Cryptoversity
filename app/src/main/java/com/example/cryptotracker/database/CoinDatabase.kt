package com.example.cryptotracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptotracker.network.Coins

@Database(entities = [Coins::class], version = 2)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun getCoinDAO() : CoinDao

    companion object{
        @Volatile
        private var INSTANCE : CoinDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK){
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CoinDatabase::class.java,
                "coin_db.db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}