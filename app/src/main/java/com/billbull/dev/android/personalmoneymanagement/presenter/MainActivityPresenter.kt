package com.billbull.dev.android.personalmoneymanagement.presenter

import com.billbull.dev.android.personalmoneymanagement.db.dao.UangMasukDao
import com.billbull.dev.android.personalmoneymanagement.util.CoroutineContextProvider
import com.billbull.dev.android.personalmoneymanagement.views.MainActivityView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityPresenter(private val view: MainActivityView, private val uangMasukDao: UangMasukDao?, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getUangMasukList() {
        view.showLoading()

        GlobalScope.launch (context.main) {
            val data = uangMasukDao?.getAllUangMasuk()
            view.showUangMasukList(data)
            view.hideLoading()
        }
    }

}