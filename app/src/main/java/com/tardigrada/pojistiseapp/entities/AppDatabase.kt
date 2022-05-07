package com.tardigrada.pojistiseapp.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tardigrada.pojistiseapp.entities.dao.InsuranceDao
import com.tardigrada.pojistiseapp.entities.dao.ProductDao
import com.tardigrada.pojistiseapp.entities.dao.UserDao

@Database(
    entities = [
        User::class,
        Product::class,
        Insurance::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val insuranceDao: InsuranceDao
    abstract val productDao: ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // function to construct the database
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}