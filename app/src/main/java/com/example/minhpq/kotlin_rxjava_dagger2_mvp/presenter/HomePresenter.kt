package com.example.minhpq.kotlin_rxjava_dagger2_mvp.presenter

import com.example.minhpq.kotlin_rxjava_dagger2_mvp.APIinterface
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewItemsRespone
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm


class HomePresenter {
    var homeView: HomeView? = null
    var apiInterface: APIinterface? = null
    var compositeDisposable = CompositeDisposable()
    var realm: Realm? = null

    constructor(homeView: HomeView?, apiInterface: APIinterface) {
        this.homeView = homeView
        this.apiInterface = apiInterface
    }

    fun getListNewItems() {
        realm= Realm.getDefaultInstance()
        compositeDisposable.add(apiInterface!!.getListNewItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ newitemsrespon: NewItemsRespone ->
                    homeView!!.showList(newitemsrespon.newsItem)
                    realm!!.beginTransaction()
                    realm!!.copyToRealmOrUpdate(newitemsrespon.newsItem)
                    realm!!.commitTransaction()
                    realm!!.close()
                })
        )
    }
    fun getListNewItemsNoInternet():List<NewsItem>{
       return realm!!.where(NewsItem::class.java).findAll()

    }
}





