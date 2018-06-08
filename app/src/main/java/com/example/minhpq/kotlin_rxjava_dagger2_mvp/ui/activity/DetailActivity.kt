package com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.R
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : BaseActivity() {
    var profile_image: CircleImageView?=null
    var tv_keywords: TextView?=null
    var tv_story: TextView?=null
    var newsItem:NewsItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profile_image=findViewById(R.id.profile_image)
        tv_keywords=findViewById(R.id.tv_keywords)
        tv_story=findViewById(R.id.tv_story)
        getDataDetail()
    }
    override fun getLayoutID(): Int {
       return R.layout.activity_detail
    }
    fun getDataDetail(){
        newsItem= getIntent().getSerializableExtra("data") as NewsItem?
        Glide.with(this).load(newsItem!!.image!!.thumb)
                .into(profile_image)
        tv_keywords!!.text=newsItem!!.Keywords
        tv_story!!.text=newsItem!!.Story

    }
}