package com.example.minhpq.kotlin_rxjava_dagger2_mvp.application

import android.app.Application
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.component.DaggerNewItemsComponent
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.component.NewItemsComponent
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.module.NewItemsModule
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application() {
    var newItemsComponent: NewItemsComponent? = null
    var realmConfiguration: RealmConfiguration? = null
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        newItemsComponent = getNewItemsComponent()
        realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)

    }

    companion object {
        fun getNewItemsComponent(): NewItemsComponent {
            return DaggerNewItemsComponent.builder().newItemsModule(NewItemsModule()).build()
        }
    }

}