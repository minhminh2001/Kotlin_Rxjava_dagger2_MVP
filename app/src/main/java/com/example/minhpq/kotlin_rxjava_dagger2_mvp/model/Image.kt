package com.example.minhpq.kotlin_rxjava_dagger2_mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import java.io.Serializable

open class Image :RealmObject(),Serializable{

    @SerializedName("Photo")
    var photo: String? = null

    @SerializedName("Thumb")
    var thumb: String? = null


    @SerializedName("PhotoCaption")
    var photoCaption: String? = null
}