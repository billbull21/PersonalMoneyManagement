package com.billbull.dev.android.personalmoneymanagement.db.dao

import androidx.room.*
import com.billbull.dev.android.personalmoneymanagement.db.entity.UangMasuk

@Dao
interface UangMasukDao {

    @Insert
    suspend fun insert(uangMasuk: UangMasuk)

    @Update
    suspend fun update(uangMasuk: UangMasuk)

    @Delete
    suspend fun delete(uangMasuk: UangMasuk)

    @Query("DELETE FROM t_uang_masuk")
    suspend fun deleteAll()

    @Query("SELECT * FROM t_uang_masuk ORDER BY id ASC")
    suspend fun getAllUangMasuk(): List<UangMasuk>

}