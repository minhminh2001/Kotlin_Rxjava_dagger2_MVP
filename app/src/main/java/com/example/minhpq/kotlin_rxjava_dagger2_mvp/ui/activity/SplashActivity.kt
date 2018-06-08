package com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.CheckConnection
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.R

class SplashActivity : BaseActivity() {
    var builder:AlertDialog.Builder?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep((2 * 1000).toLong())
                    if(CheckConnection.isOnline(baseContext)){
                        val i = Intent(baseContext,MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }else{
                        builder=AlertDialog.Builder(baseContext)
                        builder!!.setMessage(" Please check your connection")
                        builder!!.setCancelable(false)
                        builder!!.setPositiveButton("Yes", DialogInterface.OnClickListener({ dialogInterface: DialogInterface, i: Int ->
                            Toast.makeText(baseContext,"Check again",Toast.LENGTH_SHORT).show()
                        }))
                        builder!!.setNegativeButton("No",DialogInterface.OnClickListener({ dialogInterface: DialogInterface, i: Int ->
                            finish()
                        }))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
        background.start()
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

}