package com.example.minhpq.kotlin_rxjava_dagger2_mvp

import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewItemsRespone
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem
import io.reactivex.Observable
import retrofit2.http.GET

interface APIinterface {
    @GET("/feeds/newsdefaultfeeds.cms?feedtype=sjson")
    fun getListNewItems (): Observable<NewItemsRespone>
}