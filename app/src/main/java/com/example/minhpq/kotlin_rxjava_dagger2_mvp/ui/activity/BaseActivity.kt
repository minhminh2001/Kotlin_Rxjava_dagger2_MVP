package com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toolbar
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.APIinterface
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.application.MyApplication
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var apIinterface :APIinterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        MyApplication.getNewItemsComponent().inject(this)
    }

    abstract fun getLayoutID(): Int
}