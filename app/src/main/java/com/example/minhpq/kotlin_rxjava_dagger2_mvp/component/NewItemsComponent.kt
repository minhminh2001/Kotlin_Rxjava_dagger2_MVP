package com.example.minhpq.kotlin_rxjava_dagger2_mvp.component

import com.example.minhpq.kotlin_rxjava_dagger2_mvp.module.NewItemsModule
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.activity.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NewItemsModule::class])
interface NewItemsComponent {
    fun inject(baseActivity: BaseActivity)
}