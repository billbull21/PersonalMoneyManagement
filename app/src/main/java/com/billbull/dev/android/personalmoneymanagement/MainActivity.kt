package com.billbull.dev.android.personalmoneymanagement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.billbull.dev.android.personalmoneymanagement.adapter.MainActivityAdapter
import com.billbull.dev.android.personalmoneymanagement.databinding.ActivityMainBinding
import com.billbull.dev.android.personalmoneymanagement.db.dao.UangMasukDao
import com.billbull.dev.android.personalmoneymanagement.db.entity.UangMasuk
import com.billbull.dev.android.personalmoneymanagement.db.init.AppDatabase
import com.billbull.dev.android.personalmoneymanagement.presenter.MainActivityPresenter
import com.billbull.dev.android.personalmoneymanagement.util.invisible
import com.billbull.dev.android.personalmoneymanagement.util.visible
import com.billbull.dev.android.personalmoneymanagement.views.MainActivityView

class MainActivity : AppCompatActivity(), MainActivityView {

    private var db: AppDatabase? = null
    private var uangMasukDao: UangMasukDao? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityPresenter: MainActivityPresenter
    private lateinit var mainActivityAdapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // bind view (activity_main.xml)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // call database
        db = AppDatabase.getInstance(this)
        uangMasukDao = db?.uangMasukDao()

        // call the presenter
        mainActivityPresenter = MainActivityPresenter(this, uangMasukDao)

        // fetch data
        fetchAllData()

        // don't forget to do this
        setContentView(binding.root)
    }

    private fun fetchAllData() {
        mainActivityPresenter.getUangMasukList()
    }

    override fun showLoading() {
        binding.progressBar.visible()
        binding.rvUangMasuk.invisible()
    }

    override fun hideLoading() {
        binding.progressBar.invisible()
        binding.rvUangMasuk.visible()
    }

    override fun showUangMasukList(data: List<UangMasuk>?) {
        Log.d("DATA", data?.size.toString())
        mainActivityAdapter = data?.let {
            MainActivityAdapter(it) {
                Log.d("DATA", it.toString())
            }
        }!!
        binding.rvUangMasuk.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainActivityAdapter
        }
    }
}