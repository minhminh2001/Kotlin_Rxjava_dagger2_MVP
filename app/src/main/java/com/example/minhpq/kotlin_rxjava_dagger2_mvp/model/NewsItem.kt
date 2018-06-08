package com.example.minhpq.kotlin_rxjava_dagger2_mvp.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class NewsItem : RealmObject(),Serializable {
    @PrimaryKey
    @SerializedName("NewsItemId")
    var NewsItemId: String? = null

    @SerializedName("HeadLine")
    var HeadLine: String? = null

    @SerializedName("Agency")
    var Agency: String? = null

    @SerializedName("DateLine")
    var DateLine: String? = null

    @SerializedName("WebURL")
    var WebURL: String? = null

    @SerializedName("Caption")
    var Caption: String? = null

    @SerializedName("Image")
    var image: Image? = null

    @SerializedName("Keywords")
    var Keywords: String? = null

    @SerializedName("Story")
    var Story: String? = null

    @SerializedName("CommentCountUrl")
    var CommentCountUrl: String? = null

    @SerializedName("CommentFeedUrl")
    var CommentFeedUrl: String? = null

    @SerializedName("Related")
    var Related: String? = null



}