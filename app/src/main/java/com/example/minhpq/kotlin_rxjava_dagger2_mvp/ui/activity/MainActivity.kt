package com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.CheckConnection
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.R
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.R.id.rv_list
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.presenter.HomePresenter
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.adapter.ListNewItemsAdapter
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.interfaces.OnNewItemClickListener
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.view.HomeView
import io.realm.Realm

class MainActivity : BaseActivity(), HomeView, SwipeRefreshLayout.OnRefreshListener {
    var homePresenter: HomePresenter? = null
    var progressbar_main: ProgressBar? = null
    var sw_newitems: SwipeRefreshLayout? = null
    var toolbar: Toolbar? = null
    val listNewItems: MutableList<NewsItem> = mutableListOf()
    var realm: Realm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePresenter = HomePresenter(this, apIinterface!!)
        homePresenter!!.getListNewItems()
        rv_list.setHasFixedSize(true)
        rv_list.layoutManager = LinearLayoutManager(this)
        progressbar_main = findViewById(R.id.progressbar_main)
        sw_newitems = findViewById(R.id.sw_newitems)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Toi"
        sw_newitems!!.setOnRefreshListener(this)
        realm = Realm.getDefaultInstance()
        prepareSwipeRefreshLayout()
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun showList(list: List<NewsItem>) {
        sw_newitems!!.isRefreshing = false
        progressbar_main!!.visibility = View.GONE
        if (CheckConnection.isOnline(this)) {
            listNewItems.addAll(list)
        } else {
            listNewItems.addAll(homePresenter!!.getListNewItemsNoInternet())
        }
        var listAdapter = ListNewItemsAdapter(this, listNewItems, object : OnNewItemClickListener {
            override fun OnsetItemClick(position: Int) {
                var intent = Intent(baseContext, DetailActivity::class.java)
                intent.putExtra("data", listNewItems[position])
                startActivity(intent)
            }

        })
        rv_list.adapter = listAdapter
    }

    override fun onRefresh() {
        homePresenter!!.getListNewItems()
    }

    private fun prepareSwipeRefreshLayout() {
        sw_newitems!!.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
    }

}
