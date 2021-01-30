package com.billbull.dev.android.personalmoneymanagement.db.init

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.billbull.dev.android.personalmoneymanagement.db.dao.UangMasukDao
import com.billbull.dev.android.personalmoneymanagement.db.entity.UangMasuk

@Database(entities = [UangMasuk::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun uangMasukDao(): UangMasukDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java,
                    "app_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }
    }
}