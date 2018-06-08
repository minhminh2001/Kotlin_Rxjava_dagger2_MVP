package com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.adapter

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.R
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.model.NewsItem
import com.example.minhpq.kotlin_rxjava_dagger2_mvp.ui.interfaces.OnNewItemClickListener
import kotlinx.android.synthetic.main.item_view.view.*

class ListNewItemsAdapter(var mContext: Context, var list: List<NewsItem>, var onNewItemClickListener: OnNewItemClickListener) : RecyclerView.Adapter<ListNewItemsAdapter.HomeHolder>() {

    companion object {
        var mOnNewItemClickListener: OnNewItemClickListener? = null
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        mOnNewItemClickListener = onNewItemClickListener
        Glide.with(mContext).load(list[position].image!!.thumb)
                .asBitmap().centerCrop()
                .into(object : BitmapImageViewTarget(holder.image_view!!) {
                    override fun setResource(resource: Bitmap) {
                        val bitmapDrawable = RoundedBitmapDrawableFactory.create(
                                holder.image_view.resources,
                                resource)
                        bitmapDrawable.isCircular = true
                        holder.image_view!!.setImageDrawable(bitmapDrawable)
                    }
                })
        holder.tv_headLine.text = list[position].HeadLine
        holder.tv_caption.text = list[position].Caption
        holder.tv_agency.text = list[position].Agency
        holder.tv_date.text = list[position].DateLine
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mOnNewItemClickListener!!.OnsetItemClick(position)
            }
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_view, parent, false)
        return HomeHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class HomeHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var image_view = itemView.image_view
        var tv_headLine = itemView.tv_headLine
        var tv_caption = itemView.tv_caption
        var tv_agency = itemView.tv_agency
        var tv_date = itemView.tv_date
    }
}