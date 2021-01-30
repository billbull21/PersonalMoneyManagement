package com.billbull.dev.android.personalmoneymanagement.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_uang_masuk")
data class UangMasuk(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val terima_dari: String,
    val keterangan: String,
    val jumlah: Int
)