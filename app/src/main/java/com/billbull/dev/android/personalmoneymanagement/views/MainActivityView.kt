package com.billbull.dev.android.personalmoneymanagement.views

import com.billbull.dev.android.personalmoneymanagement.db.entity.UangMasuk

interface MainActivityView {
    fun showLoading()
    fun hideLoading()
    fun showUangMasukList(data: List<UangMasuk>?)
}