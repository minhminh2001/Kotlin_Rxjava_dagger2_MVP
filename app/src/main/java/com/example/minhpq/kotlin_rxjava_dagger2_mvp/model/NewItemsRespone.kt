package com.example.minhpq.kotlin_rxjava_dagger2_mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class NewItemsRespone {
    @SerializedName("Pagination")
    var Pagination: Pagination? = null
    @SerializedName("NewsItem")
    var newsItem: List<NewsItem> = ArrayList()

    constructor(Pagination: Pagination?, newsItem: List<NewsItem>) {
        this.Pagination = Pagination
        this.newsItem = newsItem
    }
}