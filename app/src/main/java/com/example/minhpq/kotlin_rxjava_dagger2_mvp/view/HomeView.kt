package com.example.minhpq.kotlin_rxjava_dagger2_mvp.view

import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem

interface HomeView {
    fun showList(list: List<NewsItem>)
}