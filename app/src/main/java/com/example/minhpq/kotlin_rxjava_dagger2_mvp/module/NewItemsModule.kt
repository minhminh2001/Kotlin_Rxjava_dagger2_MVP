package com.example.minhpq.kotlin_rxjava_dagger2_mvp.module

import com.example.minhpq.kotlin_rxjava_dagger2_mvp.APIinterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NewItemsModule {
    var retrofit :Retrofit?=null
    val URl = "https://timesofindia.indiatimes.com"

    @Provides
    @Singleton
    fun providesAPIinterface():APIinterface{
        retrofit=Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URl)
                .build()
        return retrofit!!.create(APIinterface::class.java)
    }

}